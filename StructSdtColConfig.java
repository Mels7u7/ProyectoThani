package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColConfig", namespace ="ProjectThani")
public final  class StructSdtColConfig implements Cloneable, java.io.Serializable
{
   public StructSdtColConfig( )
   {
      this( -1, new ModelContext( StructSdtColConfig.class ));
   }

   public StructSdtColConfig( int remoteHandle ,
                              ModelContext context )
   {
   }

   public  StructSdtColConfig( java.util.Vector<StructSdtConfig> value )
   {
      item = value;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   @javax.xml.bind.annotation.XmlElement(name="Config",namespace="ProjectThani")
   public java.util.Vector<StructSdtConfig> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtConfig> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtConfig> item = new java.util.Vector<>();
}

