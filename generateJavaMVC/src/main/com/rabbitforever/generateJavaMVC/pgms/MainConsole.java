package com.rabbitforever.generateJavaMVC.pgms;

import com.rabbitforever.generateJavaMVC.services.DaoGenerateMgr;
import com.rabbitforever.generateJavaMVC.services.FileArchieveMgr;
import com.rabbitforever.generateJavaMVC.services.IDaoGenerateMgr;
import com.rabbitforever.generateJavaMVC.services.IServiceGenerateMgr;
import com.rabbitforever.generateJavaMVC.services.ServiceGenerateMgr;
import com.rabbitforever.generateJavaMVC.services.VoGenerateMgr;

public class MainConsole {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{

			String argTableName = "";
			if (args.length < 1)
			{
				argTableName = "LACCCDTL.LDTHRGST.LENQLOG.LICR.LICRHTY.LICRST.LICRSTHC.LICRSTHNC.LMDRSTS.LMGICRST." +
								"LMGICRSTHC.LMGICRSTHNC.LMR.LMRHTY.LMRST.LMRSTHC.LMRSTHNC.LNPR.LNPRHTY.LNPRST.LNPRSTHC." +
								"LNPRSTHC.LNPRSTHNC.LPMT.LPMTHTY.LPMTST.LPMTSTHC.LPMTSTHNC.LPNV.LPNVHTY.LPNVST." +
								"LPNVSTHC.LPNVSTHNC.LRSD.LRSDHTY.LSCFLINF.LSDRSTS.LSPERR.LUPDPRN";
			}
			else
			{
				argTableName = args[0];
			}
			
			String delimiter = "\\.";
			String temp[];
			temp = argTableName.split(delimiter);
			
			for(int i=0; i < temp.length; i++)
			{
				FileArchieveMgr fileArchieveMgr = new FileArchieveMgr();
				fileArchieveMgr.maintainFileArchieve();
				
				VoGenerateMgr voGeneratorMgr = new VoGenerateMgr(temp[i]);
				voGeneratorMgr.generateVo();
	
				DaoGenerateMgr daoGeneratorMgr = new DaoGenerateMgr(temp[i]);
				daoGeneratorMgr.generateDao();
				
				IDaoGenerateMgr idaoGeneratorMgr = new IDaoGenerateMgr(temp[i]);
				idaoGeneratorMgr.generateDao();	
				
				
				ServiceGenerateMgr svrGeneratorMgr = new ServiceGenerateMgr(temp[i]);
				svrGeneratorMgr.generateService();
				
				IServiceGenerateMgr isvrGeneratorMgr = new IServiceGenerateMgr(temp[i]);
				isvrGeneratorMgr.generateService();
			}
			
//			MySqlDbDao mysqlDbDao = new MySqlDbDao();
//			mysqlDbDao.getColumnName(argTableName);			
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
