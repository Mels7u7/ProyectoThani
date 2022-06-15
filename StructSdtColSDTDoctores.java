package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTDoctores", namespace ="ProjectThani")
public final  class StructSdtColSDTDoctores implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTDoctores( )
   {
      this( -1, new ModelContext( StructSdtColSDTDoctores.class ));
   }

   public StructSdtColSDTDoctores( int remoteHandle ,
                                   ModelContext context )
   {
   }

   public  StructSdtColSDTDoctores( java.util.Vector<StructSdtSDTDoctores> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTDoctores",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTDoctores> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTDoctores> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTDoctores> item = new java.util.Vector<>();
}

