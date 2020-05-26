package Generator;


import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeGenerator {
    public static final String outputdir = "/src/main/java";
    public static final String author = "peigen";
    public static final String db_url = "jdbc:mysql://118.31.37.83:3306/camielbackage?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&&useSSL=false";
    public static final String db_driver = "com.mysql.jdbc.Driver";
    public static final String db_username = "peigen";
    public static final String db_password = "peigen123456";

    public static void main(String[] args){
        AutoGenerator generator = new AutoGenerator();
        GlobalConfig config = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        config.setAuthor(author);
        config.setOutputDir(projectPath+outputdir);
        config.setOpen(false);
        config.setFileOverride(false);
        //自定义文件名
        config.setMapperName("%sMapper");
        config.setServiceName("%sService");
        config.setServiceImplName("%sServiceImpl");
        generator.setGlobalConfig(config);
        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(db_url);
        dsc.setDriverName(db_driver);
        dsc.setUsername(db_username);
        dsc.setPassword(db_password);
        generator.setDataSource(dsc);
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));
        pc.setParent("com.casamiel");
        pc.setEntity("entity");
        pc.setXml("mapper");
        pc.setService("service");
        generator.setPackageInfo(pc);
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        generator.setCfg(cfg);
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        generator.setTemplate(templateConfig);
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);

        // 写于父类中的公共字段
        //strategy.setSuperEntityColumns("id");
        //strategy.setInclude(scanner("表名"));
        //strategy.setControllerMappingHyphenStyle(true);
        //strategy.setTablePrefix(pc.getModuleName() + "_");
        generator.setStrategy(strategy);
        generator.setTemplateEngine(new FreemarkerTemplateEngine());
        generator.execute();
    }


    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
}
