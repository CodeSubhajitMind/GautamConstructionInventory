package com.gautam_construction.InventoryManagement.services;

import java.io.IOException;

public interface loginServices {
	public String hashPassword(String plainTextPassword) throws Exception;
	public boolean checkPass(String plainPassword, String hashedPassword);
}
