package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColFileUploadData", namespace ="ProjectThani")
public final  class StructSdtColFileUploadData implements Cloneable, java.io.Serializable
{
   public StructSdtColFileUploadData( )
   {
      this( -1, new ModelContext( StructSdtColFileUploadData.class ));
   }

   public StructSdtColFileUploadData( int remoteHandle ,
                                      ModelContext context )
   {
   }

   public  StructSdtColFileUploadData( java.util.Vector<StructSdtFileUploadData> value )
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

   @javax.xml.bind.annotation.XmlElement(name="FileUploadData",namespace="ProjectThani")
   public java.util.Vector<StructSdtFileUploadData> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtFileUploadData> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtFileUploadData> item = new java.util.Vector<>();
}

