package com.ec;

import com.ec.Model.Frontend;
import com.ec.Model.interfaces.FrontendInterface;

public class Application {

	public static void main(String[] args) {
		FrontendInterface fi = new Frontend();
		fi.intro();
	}

}
