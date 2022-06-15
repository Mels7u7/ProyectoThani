package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTResponseTokenSession400", namespace ="ProjectThani")
public final  class StructSdtColSDTResponseTokenSession400 implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTResponseTokenSession400( )
   {
      this( -1, new ModelContext( StructSdtColSDTResponseTokenSession400.class ));
   }

   public StructSdtColSDTResponseTokenSession400( int remoteHandle ,
                                                  ModelContext context )
   {
   }

   public  StructSdtColSDTResponseTokenSession400( java.util.Vector<StructSdtSDTResponseTokenSession400> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTResponseTokenSession400",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTResponseTokenSession400> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTResponseTokenSession400> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTResponseTokenSession400> item = new java.util.Vector<>();
}

