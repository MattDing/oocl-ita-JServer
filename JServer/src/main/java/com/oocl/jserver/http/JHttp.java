package com.oocl.jserver.http;

import java.io.IOException;
import java.io.OutputStream;

public interface JHttp {
	public void sendHttp(OutputStream os) throws IOException;
}
