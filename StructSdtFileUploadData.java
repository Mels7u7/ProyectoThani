package com.projectthani ;
import com.genexus.*;

public final  class StructSdtFileUploadData implements Cloneable, java.io.Serializable
{
   public StructSdtFileUploadData( )
   {
      this( -1, new ModelContext( StructSdtFileUploadData.class ));
   }

   public StructSdtFileUploadData( int remoteHandle ,
                                   ModelContext context )
   {
      gxTv_SdtFileUploadData_Fullname = "" ;
      gxTv_SdtFileUploadData_Name = "" ;
      gxTv_SdtFileUploadData_Extension = "" ;
      gxTv_SdtFileUploadData_File = "" ;
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

   public String getFullname( )
   {
      return gxTv_SdtFileUploadData_Fullname ;
   }

   public void setFullname( String value )
   {
      gxTv_SdtFileUploadData_N = (byte)(0) ;
      gxTv_SdtFileUploadData_Fullname = value ;
   }

   public String getName( )
   {
      return gxTv_SdtFileUploadData_Name ;
   }

   public void setName( String value )
   {
      gxTv_SdtFileUploadData_N = (byte)(0) ;
      gxTv_SdtFileUploadData_Name = value ;
   }

   public String getExtension( )
   {
      return gxTv_SdtFileUploadData_Extension ;
   }

   public void setExtension( String value )
   {
      gxTv_SdtFileUploadData_N = (byte)(0) ;
      gxTv_SdtFileUploadData_Extension = value ;
   }

   public long getSize( )
   {
      return gxTv_SdtFileUploadData_Size ;
   }

   public void setSize( long value )
   {
      gxTv_SdtFileUploadData_N = (byte)(0) ;
      gxTv_SdtFileUploadData_Size = value ;
   }

   public String getFile( )
   {
      return gxTv_SdtFileUploadData_File ;
   }

   public void setFile( String value )
   {
      gxTv_SdtFileUploadData_N = (byte)(0) ;
      gxTv_SdtFileUploadData_File = value ;
   }

   protected byte gxTv_SdtFileUploadData_N ;
   protected long gxTv_SdtFileUploadData_Size ;
   protected String gxTv_SdtFileUploadData_Fullname ;
   protected String gxTv_SdtFileUploadData_Name ;
   protected String gxTv_SdtFileUploadData_Extension ;
   protected String gxTv_SdtFileUploadData_File ;
}

