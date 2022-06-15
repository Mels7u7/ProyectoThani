package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcprocesardatamedicos extends GXProcedure
{
   public prcprocesardatamedicos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcprocesardatamedicos.class ), "" );
   }

   public prcprocesardatamedicos( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( String aP0 ,
                            GXBaseCollection<com.projectthani.SdtSDTImportMedico>[] aP1 )
   {
      prcprocesardatamedicos.this.aP2 = new short[] {0};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        GXBaseCollection<com.projectthani.SdtSDTImportMedico>[] aP1 ,
                        short[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             GXBaseCollection<com.projectthani.SdtSDTImportMedico>[] aP1 ,
                             short[] aP2 )
   {
      prcprocesardatamedicos.this.AV11Filename = aP0;
      prcprocesardatamedicos.this.aP1 = aP1;
      prcprocesardatamedicos.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10ExcelDocument.Open(AV11Filename);
      AV13SDTDataMedicosList = new GXBaseCollection<com.projectthani.SdtSDTImportMedico>(com.projectthani.SdtSDTImportMedico.class, "SDTImportMedico", "ProjectThani", remoteHandle) ;
      AV8CellColumn = (short)(1) ;
      AV9CellRow = (short)(2) ;
      AV15TotalProcesados = (short)(0) ;
      while ( ! (GXutil.strcmp("", AV10ExcelDocument.Cells(AV9CellRow, AV8CellColumn, 1, 1).getText())==0) )
      {
         AV8CellColumn = (short)(1) ;
         AV12SDTDataMedicosItem = (com.projectthani.SdtSDTImportMedico)new com.projectthani.SdtSDTImportMedico(remoteHandle, context);
         AV12SDTDataMedicosItem.setgxTv_SdtSDTImportMedico_Profesionalnombres( AV10ExcelDocument.Cells(AV9CellRow, 1, 1, 1).getText() );
         AV12SDTDataMedicosItem.setgxTv_SdtSDTImportMedico_Profesionalapellidopaterno( AV10ExcelDocument.Cells(AV9CellRow, 2, 1, 1).getText() );
         AV12SDTDataMedicosItem.setgxTv_SdtSDTImportMedico_Profesionalapellidomaterno( AV10ExcelDocument.Cells(AV9CellRow, 3, 1, 1).getText() );
         AV14TipoDoc = AV10ExcelDocument.Cells(AV9CellRow, 4, 1, 1).getText() ;
         if ( GXutil.strcmp(AV14TipoDoc, "DNI") == 0 )
         {
            AV12SDTDataMedicosItem.setgxTv_SdtSDTImportMedico_Profesionaltipodocumento( "1" );
         }
         else if ( GXutil.strcmp(AV14TipoDoc, "LIBRETA ELECTORAL") == 0 )
         {
            AV12SDTDataMedicosItem.setgxTv_SdtSDTImportMedico_Profesionaltipodocumento( "2" );
         }
         else if ( GXutil.strcmp(AV14TipoDoc, "PASAPORTE") == 0 )
         {
            AV12SDTDataMedicosItem.setgxTv_SdtSDTImportMedico_Profesionaltipodocumento( "7" );
         }
         else if ( GXutil.strcmp(AV14TipoDoc, "RUC") == 0 )
         {
            AV12SDTDataMedicosItem.setgxTv_SdtSDTImportMedico_Profesionaltipodocumento( "6" );
         }
         else if ( GXutil.strcmp(AV14TipoDoc, "CARNET DE EXTRANJERIA") == 0 )
         {
            AV12SDTDataMedicosItem.setgxTv_SdtSDTImportMedico_Profesionaltipodocumento( "4" );
         }
         else if ( GXutil.strcmp(AV14TipoDoc, "SIN DOCUMENTO") == 0 )
         {
            AV12SDTDataMedicosItem.setgxTv_SdtSDTImportMedico_Profesionaltipodocumento( "0" );
         }
         AV12SDTDataMedicosItem.setgxTv_SdtSDTImportMedico_Profesionalnrodocumento( AV10ExcelDocument.Cells(AV9CellRow, 5, 1, 1).getText() );
         if ( GXutil.strcmp(AV10ExcelDocument.Cells(AV9CellRow, 6, 1, 1).getText(), "FEMENINO") == 0 )
         {
            AV12SDTDataMedicosItem.setgxTv_SdtSDTImportMedico_Profesionalsexo( "F" );
         }
         else if ( GXutil.strcmp(AV10ExcelDocument.Cells(AV9CellRow, 6, 1, 1).getText(), "MASCULINO") == 0 )
         {
            AV12SDTDataMedicosItem.setgxTv_SdtSDTImportMedico_Profesionalsexo( "M" );
         }
         AV12SDTDataMedicosItem.setgxTv_SdtSDTImportMedico_Profesionalfechanacimiento( AV10ExcelDocument.Cells(AV9CellRow, 7, 1, 1).getDate() );
         AV12SDTDataMedicosItem.setgxTv_SdtSDTImportMedico_Profesionalcop( AV10ExcelDocument.Cells(AV9CellRow, 8, 1, 1).getText() );
         AV12SDTDataMedicosItem.setgxTv_SdtSDTImportMedico_Profesionaltelefono( AV10ExcelDocument.Cells(AV9CellRow, 9, 1, 1).getText() );
         AV12SDTDataMedicosItem.setgxTv_SdtSDTImportMedico_Profesionalcorreo( AV10ExcelDocument.Cells(AV9CellRow, 10, 1, 1).getText() );
         AV12SDTDataMedicosItem.setgxTv_SdtSDTImportMedico_Profesionaldireccion( AV10ExcelDocument.Cells(AV9CellRow, 11, 1, 1).getText() );
         AV13SDTDataMedicosList.add(AV12SDTDataMedicosItem, 0);
         AV15TotalProcesados = (short)(AV15TotalProcesados+1) ;
         AV9CellRow = (short)(AV9CellRow+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcprocesardatamedicos.this.AV13SDTDataMedicosList;
      this.aP2[0] = prcprocesardatamedicos.this.AV15TotalProcesados;
      CloseOpenCursors();
      AV10ExcelDocument.cleanup();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13SDTDataMedicosList = new GXBaseCollection<com.projectthani.SdtSDTImportMedico>(com.projectthani.SdtSDTImportMedico.class, "SDTImportMedico", "ProjectThani", remoteHandle);
      AV10ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV12SDTDataMedicosItem = new com.projectthani.SdtSDTImportMedico(remoteHandle, context);
      AV14TipoDoc = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV15TotalProcesados ;
   private short AV8CellColumn ;
   private short AV9CellRow ;
   private short Gx_err ;
   private String AV11Filename ;
   private String AV14TipoDoc ;
   private short[] aP2 ;
   private GXBaseCollection<com.projectthani.SdtSDTImportMedico>[] aP1 ;
   private com.genexus.gxoffice.ExcelDoc AV10ExcelDocument ;
   private GXBaseCollection<com.projectthani.SdtSDTImportMedico> AV13SDTDataMedicosList ;
   private com.projectthani.SdtSDTImportMedico AV12SDTDataMedicosItem ;
}

