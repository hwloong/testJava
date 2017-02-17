
public class TestMemoryMain {
	public static void main(String[] args) {
		
		TestMemory m = new TestMemory(1);
		TestMemoryMain tm = new TestMemoryMain();
		System.out.println(m);
		System.out.println(m.getId());
		tm.change(m);
		System.out.println(m.getId());
	}
	
	public void change(final TestMemory t){
		System.out.println(t);
		//t = new TestMemory(10);
		t.setId(199);
		System.out.println(t);
		System.out.println(t.getId());
	}
}
