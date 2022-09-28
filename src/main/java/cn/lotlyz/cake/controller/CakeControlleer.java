package cn.lotlyz.cake.controller;

import cn.lotlyz.cake.model.Cake;
import cn.lotlyz.cake.model.Coupon;
import cn.lotlyz.cake.service.CakeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("cake")//一级访问路径
public class CakeControlleer {

    @Autowired
    private CakeService cakeService;

    @RequestMapping("findAll")
    public Map findAll(){
        List<Cake> CakeList = cakeService.findAll();

        HashMap<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","success");
        map.put("count",1000);
        map.put("data",CakeList);

        return map;
    }
    @RequestMapping("findByPage")
    public Map findByPage(
            @RequestParam(value = "page",required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(value = "limit",required = false,defaultValue = "8") Integer pageSize
    ){

        //System.out.println(pageNum);//当前页
        //System.out.println(pageSize);//每页显示条数

        //设置分页参数
        PageHelper.startPage(pageNum,pageSize);
        //紧跟在PageHelper.startPage（）后才会被分页
        List<Cake> cakeList = cakeService.findAll();

        //创建PageInfo对象
        PageInfo<Cake> pageInfo = new PageInfo<>(cakeList);

        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","success");
        map.put("count",pageInfo.getTotal());//总记录数
        map.put("data",pageInfo.getList());//分页数据

        return map;
    }

    @RequestMapping("add")
    public String add(Cake cake, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //System.out.println(patient);
        cakeService.add(cake);
        //添加完之后，跳转到首页
//        System.out.println("想看的路径"+request.getContextPath());
//        response.sendRedirect(request.getContextPath() + "index.html");

        return "success";
    }

    @RequestMapping("deleteById")
    public String deleteById(String cakeId){
        //System.out.println(id);
        cakeService.deleteById(cakeId);
        return "success";
    }

    @RequestMapping("updateCake")
    public String updateCake(Cake cake){

        System.out.println(cake);
        cakeService.updateCake(cake);

        return "success";
    }

    @RequestMapping("batchDel")
    public String batchDel(Integer [] ids){

//        System.out.println(Arrays.toString(ids));
        //判断
        if(ids.length > 0){
            cakeService.batchDel(ids);
        }

        return "success";
    }

    //MultipartFile的参数名必须是：file
    @RequestMapping("upload")
    public Map upload(MultipartFile file){
        HashMap<String, Object> map = new HashMap<>();
        if(file!=null){
            System.out.println(file.getOriginalFilename());//输出上传的文件名
            //调用上传的方法
            cakeService.upload(file);
            map.put("code",0);
            map.put("msg","success");
        }
        return map;
    }
}
