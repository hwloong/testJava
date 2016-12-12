
public class TestStr {
	public static void main(String[] args) {
		String revisitStatuss[] = {"1"};
		String strOr = " or t.revisit_status = ";
		String revisitStatusParam = " AND (t.revisit_status = ";
		String revisitStatusNull ="null";
		for(String str:revisitStatuss){
			if(!"".equals(str)){
				revisitStatusParam = revisitStatusParam + "'"+ str +"'" + strOr;
			}else{
				revisitStatusNull = str;
			}
		}
		if(revisitStatusParam.lastIndexOf(strOr) != -1 && "".equals(revisitStatusNull)){
			revisitStatusParam = revisitStatusParam.substring(0, revisitStatusParam.lastIndexOf(strOr));
			revisitStatusParam = revisitStatusParam + " or t.revisit_status is null)";
		}else if(revisitStatusParam.lastIndexOf(strOr) != -1 && !"".equals(revisitStatusNull)){
			revisitStatusParam = revisitStatusParam.substring(0, revisitStatusParam.lastIndexOf(strOr)) + ")";
		}else if("".equals(revisitStatusNull)){
			revisitStatusParam = " AND t.revisit_status is null";
		}else{
			revisitStatusParam  = revisitStatusParam + ")";
		}
		System.out.println(revisitStatusParam);
	}
}
