/**
 * 
 */
package aa.mine.superutil.thirdparty.excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import aa.mine.superutil.thirdparty.gson.GsonTools;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import aa.mine.superutil.j2se.RandomUtils;

/**
 * 自定义
 * 
 * @author Goofy 自定义表头的Excel
 */
public class CustomizeToExcel {

	// 创建工作簿
	private static Workbook wb = new SXSSFWorkbook();
	// 创建一个工作表sheet
	private static Sheet sheet = wb.createSheet();

	private static List<String> fields = new ArrayList<String>();

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 获取工作簿对象
	 * 
	 * @param columns
	 *            List<ExcelColumn> 列定义
	 * @param list
	 *            List<Map<String, Object>> 数据
	 * @return Workbook
	 * @throws IOException
	 */
	public static Workbook getWorkbook(List<ExcelColumn> columns, List<Map<String, Object>> list) throws IOException {
		GsonTools gt = new GsonTools(false, null, null, null);
		return getWorkbook(gt.toJson(columns), list);
	}

	/**
	 * 获取工作簿对象
	 * 
	 * @param columnsJsonArray
	 *            String 列定义
	 * @param list
	 *            List<Map<String, Object>> 数据
	 * @return Workbook
	 * @throws IOException
	 */
	public static Workbook getWorkbook(String columnsJsonArray, List<Map<String, Object>> list) throws IOException {
		init();
		JsonArray array = new JsonArray();
		JsonParser parser = new JsonParser();
		array = parser.parse(columnsJsonArray).getAsJsonArray();
		// 写标题
		writeTitles(array, 0, null);
		// 合并列
		mergeColumns();
		// 合并行
		mergeRows();
		// 写入行分隔符
		writeDelimiter();
		// 冻结表头
		freezeTitle();
		// 写数据
		writeData(list);

		return wb;
	}

	/**
	 * 写入到文件
	 * 
	 * @param columns
	 *            List<ExcelColumn> 列定义
	 * @param list
	 *            List<Map<String, Object>> 数据
	 * @param filePath
	 *            文件路径
	 * @throws Exception
	 */
	public static void toFile(List<ExcelColumn> columns, List<Map<String, Object>> list, String filePath) throws Exception {
		GsonTools gt = new GsonTools(false, null, null, null);
		toFile(gt.toJson(columns), list, filePath);
	}

	/**
	 * 冻结表头
	 */
	private static void freezeTitle() {
		int rowsCount = sheet.getPhysicalNumberOfRows();
		sheet.createFreezePane(0, rowsCount - 1);
	}
	
	/**
	 * 初始化workbook,sheet,fields对象，防止多次连续调用发生错误
	 */
	private static void init() {
		wb = new SXSSFWorkbook();
		sheet = wb.createSheet();
		fields = new ArrayList<String>();
	}

	/**
	 * 写入到文件
	 * 
	 * @param columnsJsonArray
	 *            String 列定义
	 * @param list
	 *            List<Map<String, Object>> 数据
	 * @param filePath
	 *            文件路径
	 * @throws Exception
	 */
	public static void toFile(String columnsJsonArray, List<Map<String, Object>> list, String filePath) throws Exception {
		FileOutputStream out = null;
		try {
			getWorkbook(columnsJsonArray, list);
			out = new FileOutputStream(filePath);
			wb.write(out);
			out.close();
		} catch (Exception e) {
			throw e;
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * 写入行数据
	 * 
	 * @param list
	 */
	private static void writeData(List<Map<String, Object>> list) {
		// 行数
		int rowsCount = sheet.getPhysicalNumberOfRows();
		// 列数
		int colsCount = sheet.getRow(0).getPhysicalNumberOfCells();
		Row row;
		Cell cell;
		CellStyle csTop = wb.createCellStyle();
		csTop.setBorderTop(HSSFCellStyle.BORDER_MEDIUM_DASHED);
		CellStyle csBottom = wb.createCellStyle();
		csBottom.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM_DASHED);
		Map<String, Object> map = new HashMap<String, Object>();
		for (int r = 0; r < list.size(); r++) {
			row = sheet.createRow(r + rowsCount - 1);
			map = list.get(r);
			for (int c = 0; c < colsCount; c++) {
				cell = row.createCell(c);
				if (r == 0) {
					cell.setCellStyle(csTop);
				}
				if (r == list.size() - 1) {
					cell.setCellStyle(csBottom);
				}
				Object v = map.get(fields.get(c));
				if (v == null) {
					cell.setCellValue("");
				} else {
					if (v.getClass().equals(Date.class)) {
						cell.setCellValue(sdf.format((Date) v));
					} else {
						cell.setCellValue(v.toString());
					}

				}

			}
		}
	}

	/**
	 * 写入列头下分隔符
	 */
	private static void writeDelimiter() {

		// 行数
		int rowsCount = sheet.getPhysicalNumberOfRows();
		// 列数
		int colsCount = sheet.getRow(0).getPhysicalNumberOfCells();
		Cell cell;
		CellStyle cs = wb.createCellStyle();
		Row row = sheet.createRow(rowsCount);
		for (int c = 0; c < colsCount; c++) {
			cell = row.createCell(c);
			cs.setBorderTop(HSSFCellStyle.BORDER_MEDIUM_DASHED);
			cell.setCellStyle(cs);
		}

	}

	/**
	 * 合并行
	 */
	private static void mergeRows() {
		// 行数
		int rowsCount = sheet.getPhysicalNumberOfRows();
		// 列数
		int colsCount = sheet.getRow(0).getPhysicalNumberOfCells();
		Row row = null;

		Cell cell = null;
		int rowSpan = 0;
		for (int c = 0; c < colsCount; c++) {
			rowSpan = 0;
			for (int r = rowsCount - 1; r > -1; r--) {

				row = sheet.getRow(r);

				cell = row.getCell(c);

				if (cell != null && r == rowsCount - 1) {
					break;
				} else if (cell != null && r != rowsCount - 1) {
					// 合并列
					sheet.addMergedRegion(new CellRangeAddress(rowsCount - rowSpan - 1, rowsCount - 1, c, c));
					break;
				} else {
					// 行合并数+1
					rowSpan++;
				}
			}
		}
	}

	/**
	 * 合并列
	 */
	private static void mergeColumns() {
		// 行数
		int rowsCount = sheet.getPhysicalNumberOfRows();
		// 列数
		int colsCount = sheet.getRow(0).getPhysicalNumberOfCells();

		Row row = null;
		Cell cell1 = null;
		Cell cell2 = null;

		int colSpan = 0;

		for (int r = 0; r < rowsCount; r++) {
			row = sheet.getRow(r);
			// 重置
			colSpan = 0;
			row = sheet.getRow(r);
			for (int c = 0; c < colsCount; c++) {
				cell1 = row.getCell(c);
				cell2 = row.getCell(c + 1);
				if (cell1 == null) {// 如果当前单元格是空的，跳过，继续当前行的后一个单元格查找
					if (c == colsCount - 1) {
						break;
					} else {
						continue;
					}
				}
				if (cell2 == null) {// 说明当前行已经到最后一个单元格了
					if (colSpan >= 1) {// 判断colSpan是否大于等于1，大于1就要合并了
						// 合并行中连续相同的值的单元格
						sheet.addMergedRegion(new CellRangeAddress(r, r, c - colSpan, c));
						break;
					}
				}

				if (cell1 != null && cell2 != null) {
					// 如果当前单元格和下一个单元格内容相同，那么colSpan加1
					if (cell1.getStringCellValue().equals(cell2.getStringCellValue())) {
						colSpan++;
					} else {
						// 如果当前单元格和下一个不等，那么判断colSpan是否大于等于1
						if (colSpan >= 1) {
							// 合并行中连续相同的值的单元格
							sheet.addMergedRegion(new CellRangeAddress(r, r, c - colSpan, c));
							// 合并后重置colSpan
							colSpan = 0;
							continue;
						}
					}
				}

			}
		}

	}

	/**
	 * 写入标题
	 * 
	 * @param array
	 *            JSON数组
	 * @param rowIndex
	 *            行号
	 * @param parentTitle
	 *            父节点名称
	 */
	private static void writeTitles(JsonArray array, int rowIndex, String parentTitle) {
		Iterator<JsonElement> it = array.iterator();
		Row row = sheet.getRow(rowIndex) == null ? sheet.createRow(rowIndex) : sheet.getRow(rowIndex);
		Row lastRow = rowIndex == 0 ? null : sheet.getRow(rowIndex - 1);

		int _colIndex = -1;
		// 遍历当前行，获取行最多的单元格的个数，因为如果之前行之前有单元格是空的，会对列索引造成问题
		int currentMaxColumns = 0;
		for (int x = 0; x < rowIndex; x++) {
			Row rr = sheet.getRow(x);
			if (rr.getPhysicalNumberOfCells() > currentMaxColumns) {
				currentMaxColumns = rr.getPhysicalNumberOfCells();
			}
		}

		// 查找上一级的列开始位置
		if (lastRow != null && parentTitle != null) {
			for (int i = 0; i < currentMaxColumns; i++) {
				if (lastRow.getCell(i) != null && lastRow.getCell(i).getStringCellValue() != null && lastRow.getCell(i).getStringCellValue().equals(parentTitle)) {
					_colIndex = i;
					break;
				}
			}
		}
		_colIndex = _colIndex == -1 ? 0 : _colIndex;

		Cell cell;

		while (it.hasNext()) {

			JsonElement e = it.next();
			// 是否是叶子节点
			boolean isLeaf = false;
			// 获取子节点数量
			int count = getSubNodesCount(e);
			// 没有子节点就是叶子节点，如果子节点为0，将count设置为1，是为了能够让下面的for循环执行一次，将标题写入
			if (count == 0) {
				count = 1;
				isLeaf = true;
			} else {
				isLeaf = false;
			}

			XSSFCellStyle cs = (XSSFCellStyle) wb.createCellStyle();
			// 水平居中
			cs.setAlignment(CellStyle.ALIGN_CENTER);
			// 垂直居中
			cs.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

			cs.setFillPattern(CellStyle.SOLID_FOREGROUND);
			// 设置前景色
			cs.setFillForegroundColor(new XSSFColor(new java.awt.Color(RandomUtils.getRandomInt(0, 255), 185, RandomUtils.getRandomInt(0, 255))));

			// 字体样式
			Font font = wb.createFont();
			// 粗体
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			// 设置字体
			cs.setFont(font);

			// 根据子节点的数量，写入相应数量的父节点的名称，待完成后合并列
			for (int i = 0; i < count; i++) {
				cell = row.createCell(_colIndex++);
				if (isLeaf) {

					// 如果没有子节点，就是浅红色的
					cs.setFillForegroundColor(new XSSFColor(new java.awt.Color(255, 199, 206)));
					if (e.getAsJsonObject().get("width") != null && e.getAsJsonObject().get("width").getAsInt() != 0) {

						fields.add(e.getAsJsonObject().get("field").getAsString());

						// 设置列宽，列宽是根据叶子节点来的，其他地方定义不生效,l列索引由于上面已经+1了，所以这里要减1
						sheet.setColumnWidth(_colIndex - 1, e.getAsJsonObject().get("width").getAsInt() * 256);
					}
				}

				cell.setCellStyle(cs);
				cell.setCellValue(e.getAsJsonObject().get("title").getAsString());
				// 判断是否写到最后一个父节点名称
				if (i == count - 1) {
					// 如果有子节点,递归写入子节点
					if (e.getAsJsonObject().get("children") != null && e.getAsJsonObject().get("children").getAsJsonArray().size() != 0) {
						writeTitles(e.getAsJsonObject().get("children").getAsJsonArray(), rowIndex + 1, e.getAsJsonObject().get("title").getAsString());
					}
				}

			}

		}
	}

	/**
	 * 获取当前节点的子节点数量
	 * 
	 * @param e
	 * @return
	 */
	private static int getSubNodesCount(JsonElement e) {
		JsonArray array = e.getAsJsonObject().get("children") == null ? null : e.getAsJsonObject().get("children").getAsJsonArray();
		if (array == null)
			return 0;

		Iterator<JsonElement> it = array.iterator();
		int count = array.size();
		while (it.hasNext()) {
			int c = getSubNodesCount(it.next());
			count += c > 0 ? c - 1 : c;
		}
		return count;
	}

	public static void main(String[] args) throws Exception {

		List<ExcelColumn> columns = new ArrayList<ExcelColumn>();

		ExcelColumn a = new ExcelColumn("A", "A", 20);

		ExcelColumn b = new ExcelColumn("B", "B", 20);

		List<ExcelColumn> columns2 = new ArrayList<ExcelColumn>();
		columns2.add(new ExcelColumn("C", "C", 30));
		columns2.add(new ExcelColumn("D", "D", 30));
		columns2.add(new ExcelColumn("E", "E", 30));

		b.setChildren(columns2);

		columns.add(b);

		// a.setChildren(columns);

		List<ExcelColumn> cs = new ArrayList<ExcelColumn>();
		cs.add(a);
		cs.add(new ExcelColumn("F", "F", 12));
		cs.add(new ExcelColumn("G", "G", 22));
		cs.add(b);

		// 造数据
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("C", "CCC");
		map1.put("D", 22);
		map1.put("E", new Date());
		list.add(map1);

		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("C", "11");
		map2.put("D", 321);
		map2.put("E", new Date());
		list.add(map2);

		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("C", "3333");
		map3.put("D", 'd');
		map3.put("E", new BigDecimal(1111));
		list.add(map3);

		list.add(map1);
		list.add(map2);
		list.add(map3);

		CustomizeToExcel
				.toFile("[{\"title\":\"A\",\"field\":\"A\",\"width\":22},{\"title\":\"B\",\"field\":\"B\",\"width\":20,\"children\":[{\"title\":\"C\",\"field\":\"C\",\"width\":30},{\"title\":\"D\",\"field\":\"D\",\"width\":30},{\"title\":\"E\",\"field\":\"E\",\"width\":30,\"children\":[{\"title\":\"X\",\"field\":\"X\",\"width\":22},{\"title\":\"Y\",\"field\":\"Y\",\"width\":22,\"children\":[{\"title\":\"EE\",\"field\":\"EE\",\"width\":22},{\"title\":\"SS\",\"field\":\"SS\",\"width\":22,\"children\":[{\"title\":\"uu\",\"field\":\"uu\",\"width\":22},{\"title\":\"i\",\"field\":\"i\",\"width\":22},{\"title\":\"o\",\"field\":\"o\",\"width\":22}]}]}]}]},{\"title\":\"Z\",\"field\":\"Z\",\"width\":22}]",
						list, "D:\\x1.xlsx");
		CustomizeToExcel.toFile(columns, list, "D:\\x2.xlsx");

	}

}
