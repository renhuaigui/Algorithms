/**   
* @Title: Producer.java
* @Package classical.ProduceAndConsume
* @Description: TODO
* @author Huaigui   
* @date 2016年9月27日 上午9:28:55
* @version V1.0   
*/
package classical.ProduceAndConsume;


/** 
 * 生产者类Producer继承线程类Thread 
 */  
public class Producer extends Thread  
{  
    // 每次生产的产品数量  
    private int num;  
  
    // 所在放置的仓库  
    private Storage storage;  
  
    // 构造函数，设置仓库  
    public Producer(Storage storage)  
    {  
        this.storage = storage;  
    }  
  
    // 线程run函数  
    public void run()  
    {  
        produce(num);  
    }  
  
    // 调用仓库Storage的生产函数  
    public void produce(int num)  
    {  
        storage.produce(num);  
    }  
  
    // get/set方法  
    public int getNum()  
    {  
        return num;  
    }  
  
    public void setNum(int num)  
    {  
        this.num = num;  
    }  
  
    public Storage getStorage()  
    {  
        return storage;  
    }  
  
    public void setStorage(Storage storage)  
    {  
        this.storage = storage;  
    }  
}  