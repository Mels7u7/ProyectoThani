package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;

public final  class gxdomaindvmessageeffect
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"N"), "No Specify");
      domain.put(new String((String)"fade"), "fade");
      domain.put(new String((String)"show"), "show");
      domain.put(new String((String)"none"), "none");
      domain.put(new String((String)"slide"), "slide");
   }

   public static String getDescription( com.genexus.internet.HttpContext httpContext ,
                                        String key )
   {
      if (domain.containsKey( key.trim() ))
      {
         return (String)domain.get( key.trim() );
      }
      else
      {
         return "";
      }
   }

   public static GXSimpleCollection<String> getValues( )
   {
      GXSimpleCollection<String> value = new GXSimpleCollection<String>(String.class, "internal", "");
      java.util.Iterator itr = domain.keySet().iterator();
      while(itr.hasNext())
      {
         value.add((String) itr.next());
      }
      return value;
   }

}

