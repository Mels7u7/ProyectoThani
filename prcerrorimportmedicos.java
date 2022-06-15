package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcerrorimportmedicos extends GXProcedure
{
   public prcerrorimportmedicos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcerrorimportmedicos.class ), "" );
   }

   public prcerrorimportmedicos( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( GXBaseCollection<com.projectthani.SdtSDTImportMedicoError> aP0 )
   {
      prcerrorimportmedicos.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( GXBaseCollection<com.projectthani.SdtSDTImportMedicoError> aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( GXBaseCollection<com.projectthani.SdtSDTImportMedicoError> aP0 ,
                             String[] aP1 )
   {
      prcerrorimportmedicos.this.AV9SDTImportMedicoErrorList = aP0;
      prcerrorimportmedicos.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV11ExcelDocument.setTemplate( "./static/Templates/ERRORIMPORTARMEDICOS.xlsx" );
      AV8FileName = "ReporteErrorImport_" + GXutil.strReplace( localUtil.dtoc( Gx_date, 3, "/"), "/", "_") + ".xlsx" ;
      AV11ExcelDocument.Open(AV8FileName);
      AV12CellRow = (short)(2) ;
      AV13CellColumn = (short)(1) ;
      AV18GXV1 = 1 ;
      while ( AV18GXV1 <= AV9SDTImportMedicoErrorList.size() )
      {
         AV10SDTImportMedicoErrorItem = (com.projectthani.SdtSDTImportMedicoError)((com.projectthani.SdtSDTImportMedicoError)AV9SDTImportMedicoErrorList.elementAt(-1+AV18GXV1));
         AV13CellColumn = (short)(1) ;
         AV11ExcelDocument.Cells(AV12CellRow, AV13CellColumn, 1, 1).setText( AV10SDTImportMedicoErrorItem.getgxTv_SdtSDTImportMedicoError_Profesionalnombres() );
         AV13CellColumn = (short)(AV13CellColumn+1) ;
         AV11ExcelDocument.Cells(AV12CellRow, AV13CellColumn, 1, 1).setText( AV10SDTImportMedicoErrorItem.getgxTv_SdtSDTImportMedicoError_Profesionalapellidopaterno() );
         AV13CellColumn = (short)(AV13CellColumn+1) ;
         AV11ExcelDocument.Cells(AV12CellRow, AV13CellColumn, 1, 1).setText( AV10SDTImportMedicoErrorItem.getgxTv_SdtSDTImportMedicoError_Profesionalapellidomaterno() );
         AV13CellColumn = (short)(AV13CellColumn+1) ;
         AV14TipoDoc = AV10SDTImportMedicoErrorItem.getgxTv_SdtSDTImportMedicoError_Profesionaltipodocumento() ;
         if ( GXutil.strcmp(AV14TipoDoc, "1") == 0 )
         {
            AV11ExcelDocument.Cells(AV12CellRow, AV13CellColumn, 1, 1).setText( "DNI" );
         }
         else if ( GXutil.strcmp(AV14TipoDoc, "2") == 0 )
         {
            AV11ExcelDocument.Cells(AV12CellRow, AV13CellColumn, 1, 1).setText( "LIBRETA ELECTORAL" );
         }
         else if ( GXutil.strcmp(AV14TipoDoc, "7") == 0 )
         {
            AV11ExcelDocument.Cells(AV12CellRow, AV13CellColumn, 1, 1).setText( "PASAPORTE" );
         }
         else if ( GXutil.strcmp(AV14TipoDoc, "6") == 0 )
         {
            AV11ExcelDocument.Cells(AV12CellRow, AV13CellColumn, 1, 1).setText( "RUC" );
         }
         else if ( GXutil.strcmp(AV14TipoDoc, "4") == 0 )
         {
            AV11ExcelDocument.Cells(AV12CellRow, AV13CellColumn, 1, 1).setText( "CARNET DE EXTRANJERIA" );
         }
         else if ( GXutil.strcmp(AV14TipoDoc, "0") == 0 )
         {
            AV11ExcelDocument.Cells(AV12CellRow, AV13CellColumn, 1, 1).setText( "SIN DOCUMENTO" );
         }
         AV13CellColumn = (short)(AV13CellColumn+1) ;
         AV11ExcelDocument.Cells(AV12CellRow, AV13CellColumn, 1, 1).setText( AV10SDTImportMedicoErrorItem.getgxTv_SdtSDTImportMedicoError_Profesionalnrodocumento() );
         AV13CellColumn = (short)(AV13CellColumn+1) ;
         if ( GXutil.strcmp(AV10SDTImportMedicoErrorItem.getgxTv_SdtSDTImportMedicoError_Profesionalsexo(), "F") == 0 )
         {
            AV11ExcelDocument.Cells(AV12CellRow, AV13CellColumn, 1, 1).setText( "FEMENINO" );
         }
         else if ( GXutil.strcmp(AV10SDTImportMedicoErrorItem.getgxTv_SdtSDTImportMedicoError_Profesionalsexo(), "M") == 0 )
         {
            AV11ExcelDocument.Cells(AV12CellRow, AV13CellColumn, 1, 1).setText( "MASCULINO" );
         }
         AV13CellColumn = (short)(AV13CellColumn+1) ;
         GXt_dtime1 = GXutil.resetTime( AV10SDTImportMedicoErrorItem.getgxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento() );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
         AV11ExcelDocument.Cells(AV12CellRow, AV13CellColumn, 1, 1).setDate( GXt_dtime1 );
         AV13CellColumn = (short)(AV13CellColumn+1) ;
         AV11ExcelDocument.Cells(AV12CellRow, AV13CellColumn, 1, 1).setText( AV10SDTImportMedicoErrorItem.getgxTv_SdtSDTImportMedicoError_Profesionalcop() );
         AV13CellColumn = (short)(AV13CellColumn+1) ;
         AV11ExcelDocument.Cells(AV12CellRow, AV13CellColumn, 1, 1).setText( AV10SDTImportMedicoErrorItem.getgxTv_SdtSDTImportMedicoError_Profesionaltelefono() );
         AV13CellColumn = (short)(AV13CellColumn+1) ;
         AV11ExcelDocument.Cells(AV12CellRow, AV13CellColumn, 1, 1).setText( AV10SDTImportMedicoErrorItem.getgxTv_SdtSDTImportMedicoError_Profesionalcorreo() );
         AV13CellColumn = (short)(AV13CellColumn+1) ;
         AV11ExcelDocument.Cells(AV12CellRow, AV13CellColumn, 1, 1).setText( AV10SDTImportMedicoErrorItem.getgxTv_SdtSDTImportMedicoError_Profesionaldireccion() );
         AV12CellRow = (short)(AV12CellRow+1) ;
         AV18GXV1 = (int)(AV18GXV1+1) ;
      }
      AV11ExcelDocument.Save();
      AV11ExcelDocument.Close();
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcerrorimportmedicos.this.AV8FileName;
      CloseOpenCursors();
      AV11ExcelDocument.cleanup();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8FileName = "" ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      Gx_date = GXutil.nullDate() ;
      AV10SDTImportMedicoErrorItem = new com.projectthani.SdtSDTImportMedicoError(remoteHandle, context);
      AV14TipoDoc = "" ;
      GXt_dtime1 = GXutil.resetTime( GXutil.nullDate() );
      Gx_date = GXutil.today( ) ;
      /* GeneXus formulas. */
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
   }

   private short AV12CellRow ;
   private short AV13CellColumn ;
   private short Gx_err ;
   private int AV18GXV1 ;
   private String AV14TipoDoc ;
   private java.util.Date GXt_dtime1 ;
   private java.util.Date Gx_date ;
   private String AV8FileName ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private String[] aP1 ;
   private GXBaseCollection<com.projectthani.SdtSDTImportMedicoError> AV9SDTImportMedicoErrorList ;
   private com.projectthani.SdtSDTImportMedicoError AV10SDTImportMedicoErrorItem ;
}

