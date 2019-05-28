package com.ofme.blog;


import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class Generator {
    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir");
        /**
         * 代码生成器
          */
        AutoGenerator mpg = new AutoGenerator();

        /**
         * 全局配置
          */
        GlobalConfig globalConfig = new GlobalConfig();
        //保存路径
        globalConfig.setOutputDir("E:\\Generator");
        //作者
        globalConfig.setAuthor("y14");
        globalConfig.setOpen(true);
        globalConfig.setBaseResultMap(true);
        globalConfig.setBaseColumnList(true);
        mpg.setGlobalConfig(globalConfig);

        /**
         * 数据源
         */
        DataSourceConfig dataSource = new DataSourceConfig();
        dataSource.setUrl("jdbc:mysql://rm-bp17pajd871eq7zxtto.mysql.rds.aliyuncs.com:3306/ofm?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true");
        dataSource.setUsername("root");
        dataSource.setPassword("tl982697020ls!@#");
        dataSource.setDriverName("com.mysql.cj.jdbc.Driver");
        mpg.setDataSource(dataSource);

        /**
         * 包配置
         */
        PackageConfig packageConfig = new PackageConfig();
        //模块名
        packageConfig.setModuleName("blog");
        //
        packageConfig.setParent("com.ofme");
        mpg.setPackageInfo(packageConfig);

        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别 实际上带上了也不会有问题。。。。。

        templateConfig.setEntity("tpl/entity.java.vm");
        templateConfig.setService("tpl/service.java.vm");
        templateConfig.setController("tpl/controller.java.vm");
        templateConfig.setServiceImpl("tpl/serviceImpl.java.vm");
        templateConfig.setXml("tpl/mapper.xml.vm");
        templateConfig.setMapper("tpl/mapper.java.vm");
        mpg.setTemplate(templateConfig);


        /**
         * 策略配置
         */
        StrategyConfig strategyConfig = new StrategyConfig();
        //表名策略
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        //字段名策略
        strategyConfig.setColumnNaming(NamingStrategy.no_change);
        //实体类超级父类
        strategyConfig.setSuperEntityClass("com.ofme.blog.base.entity.BaseEntity");
        //是否启用Lombok注解
        strategyConfig.setEntityLombokModel(true);
        //控制层是否使用RestControll
        strategyConfig.setRestControllerStyle(true);
        //控制层超级父类
        strategyConfig.setSuperControllerClass("com.ofme.blog.base.controller.BaseController");
        //表名，多个英文逗号分割
        strategyConfig.setInclude("permission","role","role_permission","user_role");
        strategyConfig.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategyConfig);
        mpg.setTemplateEngine(new VelocityTemplateEngine());
        mpg.execute();

    }
}
