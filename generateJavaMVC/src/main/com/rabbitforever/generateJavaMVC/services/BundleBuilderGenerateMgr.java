package com.rabbitforever.generateJavaMVC.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitforever.generateJavaMVC.bundles.SysProperties;
import com.rabbitforever.generateJavaMVC.commons.Misc;
import com.rabbitforever.generateJavaMVC.factories.PropertiesFactory;
import com.rabbitforever.generateJavaMVC.utils.FileUtils;

public class BundleBuilderGenerateMgr {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private String className = this.getClass().getName();
	private String fileName;
	private String objLowerFirstCharClassName;
	private SysProperties sysProperties;
	private List<String> lineList;
	
	public BundleBuilderGenerateMgr(List<String> lineList, String fileName) {
		try{
		this.fileName = fileName.replace(".properties", "");
		this.lineList = lineList;
		objLowerFirstCharClassName = "";
		sysProperties = PropertiesFactory.getInstanceOfSysPropertiesEo();
		} catch (Exception e){
			logger.error(className + ".BundleBuilderGenerateMgr()", e);
		}
	}
	
	public void generateBuilder() throws Exception {
		String outputRootDirectory = null;
		String projectFolderRoot = null;
		String phpSysConfigRoot = null;
		try {
			outputRootDirectory = sysProperties.getOutputRootDirectory();
			projectFolderRoot = sysProperties.getProjectFolderRoot();
			phpSysConfigRoot = sysProperties.getPhpSysConfigRoot();
			// Create file

			objLowerFirstCharClassName = Misc.convertBundleNameFormat2ClassNameFormat(fileName);
			String objUpperFirstCharClassName = Misc.upperStringFirstChar(objLowerFirstCharClassName);
			String fileFolder =  outputRootDirectory + "\\models\\builders";
			String objFile = fileFolder +"\\" + objUpperFirstCharClassName + "BundlesBuilder.php";
			FileUtils fileUtils = new FileUtils();
			fileUtils.createDirectoryIfNotExisted(fileFolder);
			FileWriter fstream = new FileWriter(objFile);
			BufferedWriter out = new BufferedWriter(fstream);
			// ################################################## begin writing
			// file
			StringBuilder sb = new StringBuilder();
			sb.append("<?php\n");

			// --- header
			sb.append("include_once('" + phpSysConfigRoot + "/" + projectFolderRoot + "/systems/Configs.php');\n");
			sb.append("include_once( LOG4PHP_PATH . '/RabbitLogger.php');\n");
			sb.append("include_once( DAOS_PATH . '/Dao.php');\n");
			sb.append("include_once (BUILDERS_PATH . '/BundlesBuilder.php');\n");
			sb.append("include_once (EOS_PATH . '/SystemConfigEo.php');\n");
			sb.append("include_once (EOS_PATH . '/" + objUpperFirstCharClassName + "BundlesEo.php');\n");
			
			// --- class
			sb.append("class " + objUpperFirstCharClassName + "BundlesBuilder extends BundlesBuilder");
			sb.append("{\n");

			// member variables
			sb.append("\tprivate $className;\n");
			sb.append("\tprivate $logger;\n");
			
			// constructor
			sb.append("\tpublic function __construct($fileName, $bundle = NULL){\n");
			sb.append("\t\tparent::__construct($fileName, $bundle);\n");
			sb.append("\t\t$this->fillClassName();\n");
			sb.append("\t\t$this->logger = RabbitLogger::getLogger(get_class($this));\n");
			sb.append("\t\tif ($this->bundle === NULL){\n");
			sb.append("\t\t\t$this->bundle = new " + objUpperFirstCharClassName + "BundlesEo();\n");
			sb.append("\t\t}\n");
			sb.append("\t}\n");
			
			// init
			sb.append("\tprivate function init(){\n");
			sb.append("\t}\n");
			
			
			// fillClassName
			sb.append("\tprivate function fillClassName(){\n");
			sb.append("\t\tif(!isset($this->className)){\n");
			sb.append("\t\t\t$this->className =  __CLASS__;\n");
			sb.append("\t\t}\n");
			sb.append("\t}\n");
			

			// buildBundle
			sb.append("\tpublic function buildBundle(){\n");
			sb.append("\t\t$bundleEo = NULL;\n");
			sb.append("\t\ttry{\n");
			sb.append("\t\t\t$fileContent = $this->fileUtils->readTextFile($this->fileName);\n");
			sb.append("\t\t\t$propertyArray = $this->bundleUtils->parseProperties($fileContent);\n");
			sb.append("\t\t\tif (isset($propertyArray)){\n");
			sb.append("\t\t\t\t$bundleEo = new " + objUpperFirstCharClassName + "BundlesEo($this->defaultLanguage);\n");
			
			
			
			
			// member variables - EN
			for (String line: lineList){
				String propertyString = Misc.convertBundleFieldsFormat2JavaPropertiesFormat(line, Misc.LANG_EN);
				String propertyOriginalString = Misc.convertBundleFieldsFormat2OriginalUnderScoreFormat(line, Misc.LANG_EN);
				if (propertyString != null){
					sb.append("\t\t\t\t$" + propertyString + "=$propertyArray['" + propertyOriginalString + "'];\n");
				}
			}
			// member variables - TC
			for (String line: lineList){
				String propertyString = Misc.convertBundleFieldsFormat2JavaPropertiesFormat(line, Misc.LANG_TC);
				String propertyOriginalString = Misc.convertBundleFieldsFormat2OriginalUnderScoreFormat(line, Misc.LANG_TC);
				if (propertyString != null){
					sb.append("\t\t\t\t$" + propertyString + "=$propertyArray['" + propertyOriginalString + "'];\n");
				}
			}
			
			// assign to $this->bundleEo
			
			// member variables - EN
			for (String line: lineList){
				String functionString = Misc.convertBundleFieldsFormat2JavaFnFormat(line, Misc.LANG_EN);
				String propertyString = Misc.convertBundleFieldsFormat2JavaPropertiesFormat(line, Misc.LANG_EN);
				String propertyOriginalString = Misc.convertBundleFieldsFormat2OriginalUnderScoreFormat(line, Misc.LANG_EN);
				if (propertyString != null){
					sb.append("\t\t\t\tif(isset($" + propertyString + ")){\n");
					sb.append("\t\t\t\t\t$bundleEo->set" + functionString + "(trim($" + propertyString + "));\n");
					sb.append("\t\t\t\t}\n");
				}
			}
			// member variables - TC
			for (String line: lineList){
				String functionString = Misc.convertBundleFieldsFormat2JavaFnFormat(line, Misc.LANG_TC);
				String propertyString = Misc.convertBundleFieldsFormat2JavaPropertiesFormat(line, Misc.LANG_TC);
				String propertyOriginalString = Misc.convertBundleFieldsFormat2OriginalUnderScoreFormat(line, Misc.LANG_TC);
				if (propertyString != null){
					sb.append("\t\t\t\tif(isset($" + propertyString + ")){\n");
					sb.append("\t\t\t\t\t$bundleEo->set" + functionString + "(trim($" + propertyString + "));\n");
					sb.append("\t\t\t\t}\n");
				}
			}
			
			
			
			sb.append("\t\t\t}\n");
			sb.append("\t\t} catch (Exception $ex) {\n");
			sb.append("\t\t\t$this->logger->error($this->className . '->buildBundle() - $this->fileName=' . print_r($this->fileName, 1), $ex );\n");
			sb.append("\t\t\tthrow $ex;\n");
			sb.append("\t\t}\n");
			sb.append("\t\t$this->bundleEo = $bundleEo;\n");
			sb.append("\t}\n");
			
			sb.append("}\n"); // end class Function
			sb.append("?>");
			out.write(sb.toString());

			// ################################################## end writing
			// file
			out.close();
		} catch (Exception e) {// Catch exception if any
			logger.error(className + ".generateBuilder()", e);
			throw e;
		} // end try ... catch ...
	}
}
