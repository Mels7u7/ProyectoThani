package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;

public final  class gxdomainsplitscreen_action
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new Byte((byte)1), "Go To");
      domain.put(new Byte((byte)2), "Go Back");
      domain.put(new Byte((byte)3), "Record Created");
      domain.put(new Byte((byte)4), "Record Deleted");
      domain.put(new Byte((byte)5), "Record Updated");
      domain.put(new Byte((byte)6), "Record Creation Canceled");
   }

   public static String getDescription( com.genexus.internet.HttpContext httpContext ,
                                        byte key )
   {
      if (domain.containsKey( key ))
      {
         return (String)domain.get( key );
      }
      else
      {
         return "";
      }
   }

   public static GXSimpleCollection<Byte> getValues( )
   {
      GXSimpleCollection<Byte> value = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      java.util.Iterator itr = domain.keySet().iterator();
      while(itr.hasNext())
      {
         value.add((Byte) itr.next());
      }
      return value;
   }

}

