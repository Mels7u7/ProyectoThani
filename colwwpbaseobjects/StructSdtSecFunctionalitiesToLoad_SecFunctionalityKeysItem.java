package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "SecFunctionalitiesToLoad.SecFunctionalityKeysItem", namespace ="ProjectThani")
public final  class StructSdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem implements Cloneable, java.io.Serializable
{
   public StructSdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem( )
   {
      this( -1, new ModelContext( StructSdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem.class ));
   }

   public StructSdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem( int remoteHandle ,
                                                                      ModelContext context )
   {
   }

   public  StructSdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem( java.util.Vector<StructSdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SecFunctionalitiesToLoad.SecFunctionalityKeysItem",namespace="ProjectThani")
   public java.util.Vector<StructSdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem> item = new java.util.Vector<>();
}

