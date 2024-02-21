package com.gautam_construction.InventoryManagement.services;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;


@Service
public class loginServicesImpl implements loginServices{
	@Override
	public String hashPassword(String plainTextPassword) throws Exception{
		// TODO Auto-generated method stub
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}

	@Override
	public boolean checkPass(String plainPassword, String hashedPassword) {
		// TODO Auto-generated method stub
		if (BCrypt.checkpw(plainPassword, hashedPassword))
			return true;
		else
			return false;
		
	}

	


}
