package aa.mine.superutil.thirdparty.excel;

import java.util.List;

/**
 * Excel列定义
 * @author Goofy
 */
public class ExcelColumn {

	//列名
	private String title;
	//列对应的数据中的field
	private String field;
	//列宽
	private int width=0;
	//子列
	private List<ExcelColumn> children;

	public ExcelColumn(){}
	
	public ExcelColumn(String title, String field, int width) {
		super();
		this.title = title;
		this.field = field;
		this.width = width;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @param field
	 *            the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the children
	 */
	public List<ExcelColumn> getChildren() {
		return children;
	}

	/**
	 * @param children
	 *            the children to set
	 */
	public void setChildren(List<ExcelColumn> children) {
		this.children = children;
	}

}
