var testMod = angular.module("testModule",[]);
testMod.filter("toRMB",function($log)
    {
       var toRMB = function(input)
       {
           var RMBNum = ['零',"壹","贰","叁","肆","伍","陆","柒","捌","玖","拾","佰","仟","万","亿"];
           var inputStr = input + "";
           var inputArr = new Array();
           for(i=0;i<inputStr.length;i++)
           {
               var temp = parseInt(input % 10);
               inputArr.push(temp);
               switch(i)
               {
                   case 0:inputArr.push(10);
                       break;
                   case 1:inputArr.push(11);
                       break;
                   case 2:inputArr.push(12);
                       break;
                   case 3:inputArr.push(13);
                       break;
               }
               input = input / 10;
           }
           inputArr = inputArr.reverse();
           var output = "";
           for(i=0;i<inputArr.length;i++)
           {
               output += RMBNum[inputArr[i]];
           }
           return output;
       }
       return toRMB;
    });