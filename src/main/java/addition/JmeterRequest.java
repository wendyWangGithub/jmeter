package addition;

import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class JmeterRequest extends AbstractJavaSamplerClient {
	
	private String a;
	private String b;
	private String result;
	
	public Arguments getDefaultParameters() {
		
		Arguments params = new Arguments();
		params.addArgument("num1","");
		params.addArgument("num2","");
		return params;
	}
	
	public void setupTest(JavaSamplerContext arg0) {
		
	}
	
	public SampleResult runTest(JavaSamplerContext arg0) {

		a = arg0.getParameter("num1");
		b = arg0.getParameter("num2");
		SampleResult sr = new SampleResult();
		sr.setSampleLabel("Java请求：a+b");
		try {
			sr.sampleStart();
			AddFunction addFunction = new AddFunction();
			result = String.valueOf(addFunction.sum(Integer.parseInt(a), Integer.parseInt(b)));
			if (result != null && result.length() > 0) {
				sr.setResponseData("结果是：" + result, null);
				sr.setDataType(SampleResult.TEXT);
				}
				sr.setSuccessful(true);
			} catch (Throwable e) {
				sr.setSuccessful(false);
				e.printStackTrace();
			} finally {
				sr.sampleEnd();
			}
			return sr;
		}
	
	public void teardownTest(JavaSamplerContext arg0) {
		
	}

	// main只是为了调试用，最后打jar包的时候注释掉。

     /* public static void main(String[] args)
      { // TODO Auto-generated method stub

      }
*/
	
}
	


