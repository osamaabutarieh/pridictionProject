package com.codeheros.prediction;

import jep.Jep;
import jep.JepException;
import jep.SubInterpreter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PredictionApplication {
	

	public static void main(String[] args) {//hello from the other side
		//runPython();
		SpringApplication.run(PredictionApplication.class, args);
	}
	
	private static void runPython()
	{
		try(Jep jep = new SubInterpreter())
		{ // Use SubInterpreter instead of Jep
			jep.runScript( "pythoncode/script.py" );  // Run a Python script
			
			// You can also interact with variables or functions
			//jep.eval( "from some_module import some_function" );
			//jep.eval( "result = some_function()" );
			//Object result = jep.getValue( "result" );
			//System.out.println( "Result from Python: " + result );
		}
		catch(JepException e)
		{
			e.printStackTrace();
		}
	}
}
