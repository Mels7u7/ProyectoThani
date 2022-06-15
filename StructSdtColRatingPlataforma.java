package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColRatingPlataforma", namespace ="ProjectThani")
public final  class StructSdtColRatingPlataforma implements Cloneable, java.io.Serializable
{
   public StructSdtColRatingPlataforma( )
   {
      this( -1, new ModelContext( StructSdtColRatingPlataforma.class ));
   }

   public StructSdtColRatingPlataforma( int remoteHandle ,
                                        ModelContext context )
   {
   }

   public  StructSdtColRatingPlataforma( java.util.Vector<StructSdtRatingPlataforma> value )
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

   @javax.xml.bind.annotation.XmlElement(name="RatingPlataforma",namespace="ProjectThani")
   public java.util.Vector<StructSdtRatingPlataforma> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtRatingPlataforma> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtRatingPlataforma> item = new java.util.Vector<>();
}

