
public class TestMemoryMain {
	public static void main(String[] args) {
		
		TestMemory m = new TestMemory(1);
		TestMemoryMain tm = new TestMemoryMain();
		System.out.println(m);
		System.out.println(m.getId());
		tm.change(m);
		System.out.println(m.getId());
	}
	
	public void change(TestMemory t){
		System.out.println(t);
		t = new TestMemory(10);
		System.out.println(t);
		System.out.println(t.getId());
	}
}
