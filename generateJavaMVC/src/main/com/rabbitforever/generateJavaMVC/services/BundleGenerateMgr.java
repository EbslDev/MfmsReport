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

public class BundleGenerateMgr {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private String className = this.getClass().getName();
	private String fileName;
	private String objLowerFirstCharClassName;
	private SysProperties sysProperties;
	private List<String> lineList;
	
	public BundleGenerateMgr(List<String> lineList, String fileName) {
		try{
		this.fileName = fileName.replace(".properties", "");
		this.lineList = lineList;
		objLowerFirstCharClassName = "";
		sysProperties = PropertiesFactory.getInstanceOfSysPropertiesEo();
		} catch (Exception e){
			logger.error(className + ".BundleGenerateMgr()", e);
		}
	}
	
	public void generateBundle() throws Exception {
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
			String fileFolder =  outputRootDirectory + "\\models\\bundles";
			String objFile = fileFolder +"\\" + objUpperFirstCharClassName + "BundlesEo.php";
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
			sb.append("include_once( EOS_PATH . '/BundlesEo.php');\n");
			// --- class
			sb.append("class " + objUpperFirstCharClassName + "BundlesEo extends BundlesEo");
			sb.append("{\n");
			
			// member variables - EN
			for (String line: lineList){
				String propertyString = Misc.convertBundleFieldsFormat2JavaPropertiesFormat(line, Misc.LANG_EN);
				if (propertyString != null){
					sb.append("\tprivate $" + propertyString + ";\n");
				}
			}
			// member variables - TC
			for (String line: lineList){
				String propertyString = Misc.convertBundleFieldsFormat2JavaPropertiesFormat(line, Misc.LANG_TC);
				if (propertyString != null){
					sb.append("\tprivate $" + propertyString + ";\n");
				}
			}
			
			sb.append("\tpublic function __construct($defaultLang = NULL){\n");
			sb.append("\t\tparent::__construct($defaultLang);\n");
			sb.append("\t}\n");
			
			// methods - EN
			for (String line: lineList){
				String functionString = Misc.convertBundleFieldsFormat2JavaFnFormat(line, Misc.LANG_EN);
				String propertyString = Misc.convertBundleFieldsFormat2JavaPropertiesFormat(line, Misc.LANG_EN);

				if (functionString != null){
					// setter
					sb.append("\tpublic function set" + functionString + "($" + propertyString + "){\n");
					sb.append("\t\t$this->" + propertyString + "=$" + propertyString + ";\n");
					sb.append("\t}\n");
					// getter
					sb.append("\tpublic function get" + functionString + "(){\n");
					sb.append("\t\treturn $this->" + propertyString + ";\n");
					sb.append("\t}\n");
				}
			}
			
			// methods - TC
			for (String line: lineList){
				String functionString = Misc.convertBundleFieldsFormat2JavaFnFormat(line, Misc.LANG_TC);
				String propertyString = Misc.convertBundleFieldsFormat2JavaPropertiesFormat(line, Misc.LANG_TC);

				if (functionString != null){
					// setter
					sb.append("\tpublic function set" + functionString + "($" + propertyString + "){\n");
					sb.append("\t\t$this->" + propertyString + "=$" + propertyString + ";\n");
					sb.append("\t}\n");
					// getter
					sb.append("\tpublic function get" + functionString + "(){\n");
					sb.append("\t\treturn $this->" + propertyString + ";\n");
					sb.append("\t}\n");
				}
			}
			
			
			// methods - autodetect language
			for (String line: lineList){
				String functionString = Misc.convertBundleFieldsFormat2JavaFnNoLangFormat(line, Misc.LANG_EN);
				String propertyString = Misc.convertBundleFieldsFormat2JavaPropertiesNoLangFormat(line, Misc.LANG_EN);

				if (functionString != null){
					String upperEnLang = Misc.upperStringFirstChar(Misc.LANG_EN);
					String upperTcLang = Misc.upperStringFirstChar(Misc.LANG_TC);
					// getter
					sb.append("\tpublic function get" + functionString + "(){\n");
					sb.append("\t\t$property = NULL;\n");
					sb.append("\t\tif(!isset($this->lang)){\n");
					sb.append("\t\t\t$this->lang = $this->defaultLang;\n");
					sb.append("\t\t}\n");
					sb.append("\t\tif(isset($this->lang) && $this->lang == SystemConfigEo::$LANG_TCHI){\n");
					sb.append("\t\t\t$property = $this->get" + functionString + upperTcLang + "();\n");
					sb.append("\t\t} else\n");
					sb.append("\t\tif(isset($this->lang) && $this->lang == SystemConfigEo::$LANG_EN){\n");
					sb.append("\t\t\t$property = $this->get" + functionString + upperEnLang + "();\n");
					sb.append("\t\t} else {\n");
					sb.append("\t\t\t$property = $this->get" + functionString + upperEnLang + "();\n");
					sb.append("\t\t}\n");
					sb.append("\t\treturn $property;\n");
					sb.append("\t}\n");
				}
			}
			
			// __toString() function
			sb.append("\tpublic function __toString(){\n");
			sb.append("\t\t$objectString=NULL;\n");
			sb.append("\t\t$count = 0;\n");
			sb.append("\t\tforeach($this as $key => $value){\n");
			sb.append("\t\t\tif($count > 0){\n");
			sb.append("\t\t\t\t$objString = $objectString . ',';\n");
			sb.append("\t\t\t}\n");
			sb.append("\t\t\t$objectString = $objectString . '$key => $value ';\n");
			sb.append("\t\t\t$count = $count + 1;\n");
			sb.append("\t\t}\n");
			sb.append("\t\treturn $objectString;\n");
			sb.append("\t}\n");
			
			// printAllPropertiesToJsBundlesVo() function
			sb.append("\t public function printAllPropertiesToJsBundleVo(){\n");
			sb.append("\t\ttry{\n");
			sb.append("\t\t\tforeach ($this as $key => $value){\n");
			sb.append("\t\t\t\tif (gettype($value) != \"object\"){\n");

			sb.append("\t\t\t\t\t$stringValue = '';\n");
			sb.append("\t\t\t\t\tif (gettype($value) == \"integer\"){\n");
			sb.append("\t\t\t\t\t\t$stringValue = strval($value);\n");
			sb.append("\t\t\t\t\t} else {\n");
			sb.append("\t\t\t\t\t\t$stringValue = $value;\n");
			sb.append("\t\t\t\t\t}\n");
			
			sb.append("\t\t\t\t\techo '<input type=\"hidden\" class=\"' . $key . '\" value=\"' . $stringValue. '\" />';\n");
			
			sb.append("\t\t\t\t}\n");
			sb.append("\t\t\t}\n");
			sb.append("\t\t} catch (Exception $ex) {\n");
			sb.append("\t\t\t$this->logger->error ($this->className . '->printAllPropertiesToJsBundleVo()', $ex);\n");
			sb.append("\t\t\tthrow $ex;\n");
			sb.append("\t\t}\n");
			sb.append("\t}\n");
			
			sb.append("}\n"); // end class Function
			sb.append("?>");
			out.write(sb.toString());

			// ################################################## end writing
			// file
			out.close();
		} catch (Exception e) {// Catch exception if any
			logger.error(className + ".generateBundle()", e);
			throw e;
		} // end try ... catch ...
	}
}
