package cn.ms.sequence;

import org.junit.Test;

public class SequenceTest1 {

	@Test
	public void name() {
		long start = System.currentTimeMillis();
		Sequence sequence = new Sequence(0, 0);
		for (int i = 0; i < 1; i++) {
			long id = sequence.nextId();
			System.out.println(id);
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	
	@Test
	public void sysout() {
		System.out.println(-1L ^ (-1L << 5L));
		System.out.println(-1L);
		System.out.println((-1L << 5L));
	}
}
