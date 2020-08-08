package com.ssm.rwsxx.action;

import com.ssm.rwsxx.bean.RwsBean;
import com.ssm.rwsxx.service.RwsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sunsq on 2020/8/6.
 */
@Controller
@RequestMapping("/rws")
public class RwsController {

    @Autowired
    private RwsService service;

    /**
     * 任务书列表
     * @param request
     * @return
     */
    @RequestMapping("/rwslist")
    public String selectRwsxx(HttpServletRequest request){

        try {

            List<RwsBean> rwsxx = service.rwslist();
            if (rwsxx!=null && rwsxx.size()>0){
                System.out.println("查询成功");
                request.setAttribute("rwsxx",rwsxx);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "rwspage";
    }


    /**
     * 跳转线性查找
     * @return
     */
    @RequestMapping("/tzline")
    public String tzline(){
        return "linearsearch";
    }

    /**
     * 跳转二分查找
     * @return
     */
    @RequestMapping("/tzbinary")
    public String tzbinary(){
        return "binarysearch";
    }


    /**
     * 线性查找
     * @param arraydata
     * @return
     */
    @RequestMapping("/lineSearch")
    @ResponseBody
    public Map<String,Object> lineSearch(String arraydata,String arraychardata){
        Map<String,Object> map = new HashMap();
        if (arraydata.isEmpty() || arraychardata.isEmpty()){
            map.put("result","缺少参数");
            return map;
        }

        String[] orgestr = arraydata.split(",");

        if (orgestr!=null && orgestr.length > 0){
            long start = System.currentTimeMillis();
            for (int i = 0; i < orgestr.length; i++){
                if (arraychardata.equals(orgestr[i])){

                    long end = System.currentTimeMillis();
                    long runtime = end - start;
                    map.put("result","在数组的第"+i+"位置,线性算法耗时："+runtime);
                    return map;
                }
            }
        }


        map.put("result","该字符不存在数组中");
        return map;

    }

    /**
     * 二分查找
     * @param arraydata
     * @param arraychardata
     * @return
     */
    @RequestMapping("/binarySearch")
    @ResponseBody
    public Map<String,Object> binarySearch(String arraydata,String arraychardata){
        Map<String,Object> map = new HashMap();
        if (arraydata.isEmpty() || arraychardata.isEmpty()){
            map.put("result","缺少参数");
            return map;
        }

        String[] orgestr = arraydata.split(",");
        int[] orgarray = new int[orgestr.length];
        //将字符串数组放进int数组
        for (int i = 0;i<orgestr.length;i++){
            orgarray[i] = Integer.valueOf(orgestr[i]);
        }

        if (orgarray!=null && orgarray.length > 0){


            //在这加排序
            //1.冒泡排序
            //bubbleSort(orgarray);
            //2.快速排序
            quickSort(orgarray,0,orgarray.length-1);

            long starttime = System.currentTimeMillis();
            int begin = 0;
            int end = orgarray.length-1;

            while(begin<=end){
                int middle = (end+begin)/2;
                if (Integer.valueOf(arraychardata) == orgarray[middle]){
                    long endtime = System.currentTimeMillis();
                    long runtime = endtime - starttime;
                    map.put("result","在数组的第"+middle+"位置,二分算法耗时："+runtime+"   排序后的数组："+Arrays.toString(orgarray));
                    return map;
                }else if (Integer.valueOf(arraychardata) > orgarray[middle]){
                    begin = middle+1;
                }else if (Integer.valueOf(arraychardata) < orgarray[middle]){
                    end = middle-1;
                }
            }
        }
        map.put("result","该字符不存在数组中");
        return map;
    }

    /**
     * 冒泡排序
     * @param org
     * @return
     */
    public int[] bubbleSort(int[] org){

        if(org==null || org.length < 2 ){
            return null;
        }
        for (int i = 0; i < org.length - 1; i++) {
            for (int j = 0; j < org.length - i -1; j++) {   // 这里说明为什么需要-1
                if (org[j] > org[j + 1]) {
                    int temp = org[j];
                    org[j] = org[j + 1];
                    org[j + 1] = temp;
                }
            }
        }

        return org;
    }

    /**
     * 快速排序
     *  * 参数说明：
     *     a -- 待排序的数组
     *     l -- 数组的左边界(例如，从起始位置开始排序，则l=0)
     *     r -- 数组的右边界(例如，排序截至到数组末尾，则r=a.length-1)
     * @param org
     * @return
     */
    public int[] quickSort(int org[], int l, int r){
        if (l < r){
                int i,j,x;

                i = l;
                j = r;
                x = org[i];
                while (i < j)
                {
                    while(i < j && org[j] > x)
                        j--; // 从右向左找第一个小于x的数
                    if(i < j)
                        org[i++] = org[j];
                    while(i < j && org[i] < x)
                        i++; // 从左向右找第一个大于x的数
                    if(i < j)
                        org[j--] = org[i];
                }
                org[i] = x;
                quickSort(org, l, i-1); /* 递归调用 */
                quickSort(org, i+1, r); /* 递归调用 */
            }
        return org;
    }



}