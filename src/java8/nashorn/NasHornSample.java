package java8.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NasHornSample {

	public static void main(String[] args) {
		// NasHornでjavaからjavascriptエンジンを起動できるようです。
		// 使いドコロはまだわかっていません。
		// 参考：http://den2sn.hatenablog.com/entry/2014/03/07/224928
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		try {
			engine.eval("print(1+2);");
			engine.eval("print(Java.type('java.time.ZonedDateTime').now());");
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}
}
