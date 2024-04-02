package generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.Builder;
import lombok.Getter;

public class MybatisCodeGenerator {

//    private static String dbTable = "zhangdh_order";
//    private static String dbModule = "zhangdh-order-core";
//    private static String dbParent = "com.zhangdh.order.core";

//    private static String dbTable = "zhangdh_storage";
//    private static String dbModuleParent = "zhangdh-storage";
//    private static String dbModule = "zhangdh-storage-core";
//    private static String dbParent = "com.zhangdh.storage.core";

    private static String dbTable = "zhangdh_account";
    private static String dbModuleParent = "zhangdh-account";
    private static String dbModule = "zhangdh-account-core";
    private static String dbParent = "com.zhangdh.account.core";

    private static String filePath = dbModuleParent + "/" + dbModule;
    private static String dbUrl = "jdbc:mysql://10.50.100.133:31721/seata_yinshi?useSSL=false";
    private static String username = "root";
    private static String password = "123";

    public static void main(String[] args) {
        Table table = Table.builder().tableName(dbTable)
                .module(dbModule)
                .parent(dbParent)
                .build();
        String moduleName = table.getTableName();
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String file = MybatisCodeGenerator.class.getResource(".").getFile();
        gc.setOutputDir(file.substring(0, file.indexOf("/target")) + "/../../" + filePath + "/src/main/java");
        gc.setAuthor("zhangdh");
        gc.setOpen(false);
        gc.setSwagger2(true);
        gc.setEntityName("%sEntity");
        gc.setServiceName("%sManager");
        gc.setServiceImplName("%sManagerImpl");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(dbUrl);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setDbType(DbType.MYSQL);
        dsc.setUsername(username);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName(moduleName);
        pc.setParent(table.parent).setMapper("mapper").setEntity("entity").setService("manager").setServiceImpl("manager.impl");
        mpg.setPackageInfo(pc);
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        templateConfig.setController("");
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);

        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
//        strategy.setSuperEntityClass(BaseEntity.class);
//        strategy.setSuperEntityColumns(BaseEntity.getFields());
        strategy.setInclude(moduleName);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix("zhangdh_");
//        strategy.setChainModel(true);


        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    @Builder
    @Getter
    static class Table {
        private String tableName;
        private String module;
        private String parent;
    }
}
