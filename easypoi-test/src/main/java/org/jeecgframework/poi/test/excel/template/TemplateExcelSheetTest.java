package org.jeecgframework.poi.test.excel.template;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.params.ExcelExportEntity;
import org.jeecgframework.poi.excel.export.ExcelExportServer;
import org.jeecgframework.poi.excel.export.template.ExcelExportOfTemplateUtil;
import org.junit.Test;

public class TemplateExcelSheetTest {

    @Test
    public void test() throws Exception {
        ExcelExportServer util = new ExcelExportServer();
        Workbook workbook = new HSSFWorkbook();
        ExportParams entity = new ExportParams();
        entity.setCreateHeadRows(false);
        entity.setStyle(ManySheetOneSyler.class);
        List<ExcelExportEntity> entityList = new ArrayList<ExcelExportEntity>();
        ExcelExportEntity e = new ExcelExportEntity();
        e.setHeight(40);
        e.setWidth(40);
        e.setWrap(true);
        e.setName("one");
        e.setKey("one");
        entityList.add(e);
        e = new ExcelExportEntity();
        e.setHeight(40);
        e.setWidth(40);
        e.setWrap(true);
        e.setName("two");
        e.setKey("two");
        entityList.add(e);
        e = new ExcelExportEntity();
        e.setHeight(40);
        e.setWidth(40);
        e.setWrap(true);
        e.setName("three");
        e.setKey("three");
        entityList.add(e);
        e = new ExcelExportEntity();
        e.setHeight(40);
        e.setWidth(40);
        e.setWrap(true);
        e.setName("four");
        e.setKey("four");
        entityList.add(e);
        e = new ExcelExportEntity();
        e.setHeight(40);
        e.setWidth(40);
        e.setWrap(true);
        e.setName("five");
        e.setKey("five");
        entityList.add(e);

        //这里加入了40个数据源
        List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
        for (int l = 0; l < 80; l++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("one",
                "卡片编号：2228\n资产名称：办公器\n开始使用日期：20090910\n使用状况：在用\n使用科室：财务科\n管理科室：总务科\n市妇幼2015年6月");
            map.put("two",
                "卡片编号：2228\n资产名称：办公器\n开始使用日期：20090910\n使用状况：在用\n使用科室：财务科\n管理科室：总务科\n市妇幼2015年6月");
            map.put("three",
                "卡片编号：2228\n资产名称：办公器\n开始使用日期：20090910\n使用状况：在用\n使用科室：财务科\n管理科室：总务科\n市妇幼2015年6月");
            map.put("five",
                "卡片编号：2228\n资产名称：办公器\n开始使用日期：20090910\n使用状况：在用\n使用科室：财务科\n管理科室：总务科\n市妇幼2015年6月");
            map.put("four",
                "卡片编号：2228\n资产名称：办公器\n开始使用日期：20090910\n使用状况：在用\n使用科室：财务科\n管理科室：总务科\n市妇幼2015年6月");
            dataList.add(map);
        }

        //补全数据好看一点
        for (int l = 0, le = (dataList.size() % 6) == 0 ? 0 : 6 - dataList.size() % 6; l < le; l++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("one", "");
            map.put("two", "");
            map.put("three", "");
            map.put("five", "");
            map.put("four", "");
            dataList.add(map);
        }

        for (int i = 0, le = dataList.size() / 6; i < le; i++) {
            util.createSheetForMap(workbook, entity, entityList, dataList.subList(0, 6));
        }
        File savefile = new File("d:/");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream("d:/foreach.xls");
        workbook.write(fos);
        fos.close();
    }

    public void createSheetForMap(Workbook workbook, ExportParams entity,
                                  List<ExcelExportEntity> entityList,
                                  Collection<? extends Map<?, ?>> dataSet) {

    }

}
