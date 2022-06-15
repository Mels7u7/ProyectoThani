package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "SecFunctionalityRole", namespace ="ProjectThani")
public final  class StructSdtSecFunctionalityRole implements Cloneable, java.io.Serializable
{
   public StructSdtSecFunctionalityRole( )
   {
      this( -1, new ModelContext( StructSdtSecFunctionalityRole.class ));
   }

   public StructSdtSecFunctionalityRole( int remoteHandle ,
                                         ModelContext context )
   {
   }

   public  StructSdtSecFunctionalityRole( java.util.Vector<StructSdtSecFunctionalityRole> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SecFunctionalityRole",namespace="ProjectThani")
   public java.util.Vector<StructSdtSecFunctionalityRole> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSecFunctionalityRole> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSecFunctionalityRole> item = new java.util.Vector<>();
}

