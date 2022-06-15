package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColConfComision", namespace ="ProjectThani")
public final  class StructSdtColConfComision implements Cloneable, java.io.Serializable
{
   public StructSdtColConfComision( )
   {
      this( -1, new ModelContext( StructSdtColConfComision.class ));
   }

   public StructSdtColConfComision( int remoteHandle ,
                                    ModelContext context )
   {
   }

   public  StructSdtColConfComision( java.util.Vector<StructSdtConfComision> value )
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

   @javax.xml.bind.annotation.XmlElement(name="ConfComision",namespace="ProjectThani")
   public java.util.Vector<StructSdtConfComision> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtConfComision> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtConfComision> item = new java.util.Vector<>();
}

