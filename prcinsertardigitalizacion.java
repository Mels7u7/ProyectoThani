package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcinsertardigitalizacion extends GXProcedure
{
   public prcinsertardigitalizacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcinsertardigitalizacion.class ), "" );
   }

   public prcinsertardigitalizacion( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String aP2 ,
                              String aP3 )
   {
      prcinsertardigitalizacion.this.aP4 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        boolean[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             boolean[] aP4 )
   {
      prcinsertardigitalizacion.this.AV8CitaId = aP0;
      prcinsertardigitalizacion.this.AV10Blob = aP1;
      prcinsertardigitalizacion.this.AV11FileName = aP2;
      prcinsertardigitalizacion.this.AV13Extension = aP3;
      prcinsertardigitalizacion.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9isSaved = false ;
      AV12RecetaMedica.setgxTv_SdtRecetaMedica_Citaid( AV8CitaId );
      AV12RecetaMedica.setgxTv_SdtRecetaMedica_Medicamentoid_SetNull();
      AV12RecetaMedica.setgxTv_SdtRecetaMedica_Recetamedicaarchivo( AV10Blob );
      AV12RecetaMedica.setgxTv_SdtRecetaMedica_Recetamedicaflag( (byte)(0) );
      AV12RecetaMedica.setgxTv_SdtRecetaMedica_Recetamedicanombrearchivo( AV11FileName );
      AV12RecetaMedica.setgxTv_SdtRecetaMedica_Recetaarchivotipo( AV13Extension );
      AV12RecetaMedica.Save();
      if ( AV12RecetaMedica.Success() )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "prcinsertardigitalizacion");
         AV9isSaved = true ;
      }
      else
      {
         AV9isSaved = false ;
         Application.rollbackDataStores(context, remoteHandle, pr_default, "prcinsertardigitalizacion");
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = prcinsertardigitalizacion.this.AV9isSaved;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12RecetaMedica = new com.projectthani.SdtRecetaMedica(remoteHandle);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcinsertardigitalizacion__default(),
         new Object[] {
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CitaId ;
   private boolean AV9isSaved ;
   private String AV10Blob ;
   private String AV11FileName ;
   private String AV13Extension ;
   private com.projectthani.SdtRecetaMedica AV12RecetaMedica ;
   private boolean[] aP4 ;
   private IDataStoreProvider pr_default ;
}

final  class prcinsertardigitalizacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

