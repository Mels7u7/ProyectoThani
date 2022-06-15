package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class recetamedicawwexport extends GXProcedure
{
   public recetamedicawwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( recetamedicawwexport.class ), "" );
   }

   public recetamedicawwexport( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      recetamedicawwexport.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String[] aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String[] aP0 ,
                             String[] aP1 )
   {
      recetamedicawwexport.this.aP0 = aP0;
      recetamedicawwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWRecetaMedica", GXv_boolean2) ;
      recetamedicawwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV62Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'OPENDOCUMENT' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV14CellRow = 1 ;
         AV15FirstColumn = 1 ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S201 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITEFILTERS' */
         S131 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITECOLUMNTITLES' */
         S141 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITEDATA' */
         S161 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'CLOSEDOCUMENT' */
         S191 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'OPENDOCUMENT' Routine */
      returnInSub = false ;
      AV16Random = (int)(GXutil.random( )*10000) ;
      AV12Filename = "RecetaMedicaWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
      AV11ExcelDocument.Open(AV12Filename);
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV11ExcelDocument.Clear();
   }

   public void S131( )
   {
      /* 'WRITEFILTERS' Routine */
      returnInSub = false ;
      if ( ! ( (GXutil.strcmp("", AV19FilterFullText)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Filter") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         recetamedicawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV19FilterFullText, GXv_char7) ;
         recetamedicawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      if ( ! ( (0==AV35TFRecetaMedicaId) && (0==AV36TFRecetaMedicaId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Medica Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         recetamedicawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFRecetaMedicaId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         recetamedicawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFRecetaMedicaId_To );
      }
      if ( ! ( (0==AV37TFCitaId) && (0==AV38TFCitaId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Cita Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         recetamedicawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV37TFCitaId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         recetamedicawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV38TFCitaId_To );
      }
      if ( ! ( (0==AV39TFMedicamentoId) && (0==AV40TFMedicamentoId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Medicamento Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         recetamedicawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV39TFMedicamentoId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         recetamedicawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV40TFMedicamentoId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV42TFMedicamentoCodigo_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Medicamento Codigo") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         recetamedicawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFMedicamentoCodigo_Sel, GXv_char7) ;
         recetamedicawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV41TFMedicamentoCodigo)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Medicamento Codigo") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            recetamedicawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV41TFMedicamentoCodigo, GXv_char7) ;
            recetamedicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV44TFMedicamentoNombre_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Medicamento Nombre") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         recetamedicawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV44TFMedicamentoNombre_Sel, GXv_char7) ;
         recetamedicawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV43TFMedicamentoNombre)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Medicamento Nombre") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            recetamedicawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV43TFMedicamentoNombre, GXv_char7) ;
            recetamedicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV46TFMedicamentoFormaFarm_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Medicamento Forma Farm") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         recetamedicawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV46TFMedicamentoFormaFarm_Sel, GXv_char7) ;
         recetamedicawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV45TFMedicamentoFormaFarm)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Medicamento Forma Farm") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            recetamedicawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV45TFMedicamentoFormaFarm, GXv_char7) ;
            recetamedicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV48TFRecetaMedicaConcentracion_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Medica Concentracion") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         recetamedicawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV48TFRecetaMedicaConcentracion_Sel, GXv_char7) ;
         recetamedicawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV47TFRecetaMedicaConcentracion)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Medica Concentracion") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            recetamedicawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV47TFRecetaMedicaConcentracion, GXv_char7) ;
            recetamedicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV49TFRecetaMedicaCantidad) && (0==AV50TFRecetaMedicaCantidad_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Medica Cantidad") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         recetamedicawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV49TFRecetaMedicaCantidad );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         recetamedicawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV50TFRecetaMedicaCantidad_To );
      }
      if ( ! ( (GXutil.strcmp("", AV52TFRecetaMedicaAtencion_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Medica Atencion") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         recetamedicawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV52TFRecetaMedicaAtencion_Sel, GXv_char7) ;
         recetamedicawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV51TFRecetaMedicaAtencion)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Medica Atencion") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            recetamedicawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV51TFRecetaMedicaAtencion, GXv_char7) ;
            recetamedicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV55TFRecetaMedicaFlag) && (0==AV56TFRecetaMedicaFlag_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Medica Flag") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         recetamedicawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV55TFRecetaMedicaFlag );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         recetamedicawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV56TFRecetaMedicaFlag_To );
      }
      if ( ! ( (GXutil.strcmp("", AV59TFRecetaIndicaciones_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Indicaciones") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         recetamedicawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV59TFRecetaIndicaciones_Sel, GXv_char7) ;
         recetamedicawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV58TFRecetaIndicaciones)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Indicaciones") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            recetamedicawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV58TFRecetaIndicaciones, GXv_char7) ;
            recetamedicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("RecetaMedicaWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("RecetaMedicaWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV63GXV1 = 1 ;
      while ( AV63GXV1 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV63GXV1));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV63GXV1 = (int)(AV63GXV1+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV65Recetamedicawwds_1_filterfulltext = AV19FilterFullText ;
      AV66Recetamedicawwds_2_tfrecetamedicaid = AV35TFRecetaMedicaId ;
      AV67Recetamedicawwds_3_tfrecetamedicaid_to = AV36TFRecetaMedicaId_To ;
      AV68Recetamedicawwds_4_tfcitaid = AV37TFCitaId ;
      AV69Recetamedicawwds_5_tfcitaid_to = AV38TFCitaId_To ;
      AV70Recetamedicawwds_6_tfmedicamentoid = AV39TFMedicamentoId ;
      AV71Recetamedicawwds_7_tfmedicamentoid_to = AV40TFMedicamentoId_To ;
      AV72Recetamedicawwds_8_tfmedicamentocodigo = AV41TFMedicamentoCodigo ;
      AV73Recetamedicawwds_9_tfmedicamentocodigo_sel = AV42TFMedicamentoCodigo_Sel ;
      AV74Recetamedicawwds_10_tfmedicamentonombre = AV43TFMedicamentoNombre ;
      AV75Recetamedicawwds_11_tfmedicamentonombre_sel = AV44TFMedicamentoNombre_Sel ;
      AV76Recetamedicawwds_12_tfmedicamentoformafarm = AV45TFMedicamentoFormaFarm ;
      AV77Recetamedicawwds_13_tfmedicamentoformafarm_sel = AV46TFMedicamentoFormaFarm_Sel ;
      AV78Recetamedicawwds_14_tfrecetamedicaconcentracion = AV47TFRecetaMedicaConcentracion ;
      AV79Recetamedicawwds_15_tfrecetamedicaconcentracion_sel = AV48TFRecetaMedicaConcentracion_Sel ;
      AV80Recetamedicawwds_16_tfrecetamedicacantidad = AV49TFRecetaMedicaCantidad ;
      AV81Recetamedicawwds_17_tfrecetamedicacantidad_to = AV50TFRecetaMedicaCantidad_To ;
      AV82Recetamedicawwds_18_tfrecetamedicaatencion = AV51TFRecetaMedicaAtencion ;
      AV83Recetamedicawwds_19_tfrecetamedicaatencion_sel = AV52TFRecetaMedicaAtencion_Sel ;
      AV84Recetamedicawwds_20_tfrecetamedicaflag = AV55TFRecetaMedicaFlag ;
      AV85Recetamedicawwds_21_tfrecetamedicaflag_to = AV56TFRecetaMedicaFlag_To ;
      AV86Recetamedicawwds_22_tfrecetaindicaciones = AV58TFRecetaIndicaciones ;
      AV87Recetamedicawwds_23_tfrecetaindicaciones_sel = AV59TFRecetaIndicaciones_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV65Recetamedicawwds_1_filterfulltext ,
                                           Short.valueOf(AV66Recetamedicawwds_2_tfrecetamedicaid) ,
                                           Short.valueOf(AV67Recetamedicawwds_3_tfrecetamedicaid_to) ,
                                           Integer.valueOf(AV68Recetamedicawwds_4_tfcitaid) ,
                                           Integer.valueOf(AV69Recetamedicawwds_5_tfcitaid_to) ,
                                           Short.valueOf(AV70Recetamedicawwds_6_tfmedicamentoid) ,
                                           Short.valueOf(AV71Recetamedicawwds_7_tfmedicamentoid_to) ,
                                           AV73Recetamedicawwds_9_tfmedicamentocodigo_sel ,
                                           AV72Recetamedicawwds_8_tfmedicamentocodigo ,
                                           AV75Recetamedicawwds_11_tfmedicamentonombre_sel ,
                                           AV74Recetamedicawwds_10_tfmedicamentonombre ,
                                           AV77Recetamedicawwds_13_tfmedicamentoformafarm_sel ,
                                           AV76Recetamedicawwds_12_tfmedicamentoformafarm ,
                                           AV79Recetamedicawwds_15_tfrecetamedicaconcentracion_sel ,
                                           AV78Recetamedicawwds_14_tfrecetamedicaconcentracion ,
                                           Short.valueOf(AV80Recetamedicawwds_16_tfrecetamedicacantidad) ,
                                           Short.valueOf(AV81Recetamedicawwds_17_tfrecetamedicacantidad_to) ,
                                           AV83Recetamedicawwds_19_tfrecetamedicaatencion_sel ,
                                           AV82Recetamedicawwds_18_tfrecetamedicaatencion ,
                                           Byte.valueOf(AV84Recetamedicawwds_20_tfrecetamedicaflag) ,
                                           Byte.valueOf(AV85Recetamedicawwds_21_tfrecetamedicaflag_to) ,
                                           AV87Recetamedicawwds_23_tfrecetaindicaciones_sel ,
                                           AV86Recetamedicawwds_22_tfrecetaindicaciones ,
                                           Short.valueOf(A50RecetaMedicaId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           Short.valueOf(A42MedicamentoId) ,
                                           A229MedicamentoCodigo ,
                                           A230MedicamentoNombre ,
                                           A231MedicamentoFormaFarm ,
                                           A268RecetaMedicaConcentracion ,
                                           Short.valueOf(A269RecetaMedicaCantidad) ,
                                           A273RecetaMedicaAtencion ,
                                           Byte.valueOf(A272RecetaMedicaFlag) ,
                                           A332RecetaIndicaciones ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV65Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV65Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV65Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV65Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV65Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV65Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV65Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV65Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV65Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV65Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV65Recetamedicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Recetamedicawwds_1_filterfulltext), "%", "") ;
      lV72Recetamedicawwds_8_tfmedicamentocodigo = GXutil.concat( GXutil.rtrim( AV72Recetamedicawwds_8_tfmedicamentocodigo), "%", "") ;
      lV74Recetamedicawwds_10_tfmedicamentonombre = GXutil.concat( GXutil.rtrim( AV74Recetamedicawwds_10_tfmedicamentonombre), "%", "") ;
      lV76Recetamedicawwds_12_tfmedicamentoformafarm = GXutil.concat( GXutil.rtrim( AV76Recetamedicawwds_12_tfmedicamentoformafarm), "%", "") ;
      lV78Recetamedicawwds_14_tfrecetamedicaconcentracion = GXutil.concat( GXutil.rtrim( AV78Recetamedicawwds_14_tfrecetamedicaconcentracion), "%", "") ;
      lV82Recetamedicawwds_18_tfrecetamedicaatencion = GXutil.concat( GXutil.rtrim( AV82Recetamedicawwds_18_tfrecetamedicaatencion), "%", "") ;
      lV86Recetamedicawwds_22_tfrecetaindicaciones = GXutil.concat( GXutil.rtrim( AV86Recetamedicawwds_22_tfrecetaindicaciones), "%", "") ;
      /* Using cursor P004Z2 */
      pr_default.execute(0, new Object[] {lV65Recetamedicawwds_1_filterfulltext, lV65Recetamedicawwds_1_filterfulltext, lV65Recetamedicawwds_1_filterfulltext, lV65Recetamedicawwds_1_filterfulltext, lV65Recetamedicawwds_1_filterfulltext, lV65Recetamedicawwds_1_filterfulltext, lV65Recetamedicawwds_1_filterfulltext, lV65Recetamedicawwds_1_filterfulltext, lV65Recetamedicawwds_1_filterfulltext, lV65Recetamedicawwds_1_filterfulltext, lV65Recetamedicawwds_1_filterfulltext, Short.valueOf(AV66Recetamedicawwds_2_tfrecetamedicaid), Short.valueOf(AV67Recetamedicawwds_3_tfrecetamedicaid_to), Integer.valueOf(AV68Recetamedicawwds_4_tfcitaid), Integer.valueOf(AV69Recetamedicawwds_5_tfcitaid_to), Short.valueOf(AV70Recetamedicawwds_6_tfmedicamentoid), Short.valueOf(AV71Recetamedicawwds_7_tfmedicamentoid_to), lV72Recetamedicawwds_8_tfmedicamentocodigo, AV73Recetamedicawwds_9_tfmedicamentocodigo_sel, lV74Recetamedicawwds_10_tfmedicamentonombre, AV75Recetamedicawwds_11_tfmedicamentonombre_sel, lV76Recetamedicawwds_12_tfmedicamentoformafarm, AV77Recetamedicawwds_13_tfmedicamentoformafarm_sel, lV78Recetamedicawwds_14_tfrecetamedicaconcentracion, AV79Recetamedicawwds_15_tfrecetamedicaconcentracion_sel, Short.valueOf(AV80Recetamedicawwds_16_tfrecetamedicacantidad), Short.valueOf(AV81Recetamedicawwds_17_tfrecetamedicacantidad_to), lV82Recetamedicawwds_18_tfrecetamedicaatencion, AV83Recetamedicawwds_19_tfrecetamedicaatencion_sel, Byte.valueOf(AV84Recetamedicawwds_20_tfrecetamedicaflag), Byte.valueOf(AV85Recetamedicawwds_21_tfrecetamedicaflag_to), lV86Recetamedicawwds_22_tfrecetaindicaciones, AV87Recetamedicawwds_23_tfrecetaindicaciones_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A272RecetaMedicaFlag = P004Z2_A272RecetaMedicaFlag[0] ;
         n272RecetaMedicaFlag = P004Z2_n272RecetaMedicaFlag[0] ;
         A269RecetaMedicaCantidad = P004Z2_A269RecetaMedicaCantidad[0] ;
         n269RecetaMedicaCantidad = P004Z2_n269RecetaMedicaCantidad[0] ;
         A42MedicamentoId = P004Z2_A42MedicamentoId[0] ;
         n42MedicamentoId = P004Z2_n42MedicamentoId[0] ;
         A19CitaId = P004Z2_A19CitaId[0] ;
         A50RecetaMedicaId = P004Z2_A50RecetaMedicaId[0] ;
         A332RecetaIndicaciones = P004Z2_A332RecetaIndicaciones[0] ;
         A273RecetaMedicaAtencion = P004Z2_A273RecetaMedicaAtencion[0] ;
         n273RecetaMedicaAtencion = P004Z2_n273RecetaMedicaAtencion[0] ;
         A268RecetaMedicaConcentracion = P004Z2_A268RecetaMedicaConcentracion[0] ;
         n268RecetaMedicaConcentracion = P004Z2_n268RecetaMedicaConcentracion[0] ;
         A231MedicamentoFormaFarm = P004Z2_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = P004Z2_n231MedicamentoFormaFarm[0] ;
         A230MedicamentoNombre = P004Z2_A230MedicamentoNombre[0] ;
         A229MedicamentoCodigo = P004Z2_A229MedicamentoCodigo[0] ;
         A231MedicamentoFormaFarm = P004Z2_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = P004Z2_n231MedicamentoFormaFarm[0] ;
         A230MedicamentoNombre = P004Z2_A230MedicamentoNombre[0] ;
         A229MedicamentoCodigo = P004Z2_A229MedicamentoCodigo[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV32VisibleColumnCount = 0 ;
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A50RecetaMedicaId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A19CitaId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A42MedicamentoId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A229MedicamentoCodigo, GXv_char7) ;
            recetamedicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A230MedicamentoNombre, GXv_char7) ;
            recetamedicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A231MedicamentoFormaFarm, GXv_char7) ;
            recetamedicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A268RecetaMedicaConcentracion, GXv_char7) ;
            recetamedicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A269RecetaMedicaCantidad );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A273RecetaMedicaAtencion, GXv_char7) ;
            recetamedicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( "" );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A272RecetaMedicaFlag );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A332RecetaIndicaciones, GXv_char7) ;
            recetamedicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S182 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S191( )
   {
      /* 'CLOSEDOCUMENT' Routine */
      returnInSub = false ;
      AV11ExcelDocument.Save();
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV11ExcelDocument.Close();
   }

   public void S121( )
   {
      /* 'CHECKSTATUS' Routine */
      returnInSub = false ;
      if ( AV11ExcelDocument.getErrCode() != 0 )
      {
         AV12Filename = "" ;
         AV13ErrorMessage = AV11ExcelDocument.getErrDescription() ;
         AV11ExcelDocument.Close();
         returnInSub = true;
         if (true) return;
      }
   }

   public void S151( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV24ColumnsSelector = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector)new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "RecetaMedicaId", "", "Medica Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CitaId", "", "Cita Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "MedicamentoId", "", "Medicamento Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "MedicamentoCodigo", "", "Medicamento Codigo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "MedicamentoNombre", "", "Medicamento Nombre", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "MedicamentoFormaFarm", "", "Medicamento Forma Farm", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "RecetaMedicaConcentracion", "", "Medica Concentracion", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "RecetaMedicaCantidad", "", "Medica Cantidad", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "RecetaMedicaAtencion", "", "Medica Atencion", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "RecetaMedicaArchivo", "", "Medica Archivo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "RecetaMedicaFlag", "", "Medica Flag", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "RecetaIndicaciones", "", "Indicaciones", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV28UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "RecetaMedicaWWColumnsSelector", GXv_char7) ;
      recetamedicawwexport.this.GXt_char6 = GXv_char7[0] ;
      AV28UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV28UserCustomValue)==0) ) )
      {
         AV25ColumnsSelectorAux.fromxml(AV28UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
         new com.projectthani.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV25ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("RecetaMedicaWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "RecetaMedicaWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("RecetaMedicaWWGridState"), null, null);
      }
      AV17OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV18OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV88GXV2 = 1 ;
      while ( AV88GXV2 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV88GXV2));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV19FilterFullText = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAMEDICAID") == 0 )
         {
            AV35TFRecetaMedicaId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFRecetaMedicaId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAID") == 0 )
         {
            AV37TFCitaId = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV38TFCitaId_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOID") == 0 )
         {
            AV39TFMedicamentoId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV40TFMedicamentoId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOCODIGO") == 0 )
         {
            AV41TFMedicamentoCodigo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOCODIGO_SEL") == 0 )
         {
            AV42TFMedicamentoCodigo_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTONOMBRE") == 0 )
         {
            AV43TFMedicamentoNombre = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTONOMBRE_SEL") == 0 )
         {
            AV44TFMedicamentoNombre_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOFORMAFARM") == 0 )
         {
            AV45TFMedicamentoFormaFarm = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEDICAMENTOFORMAFARM_SEL") == 0 )
         {
            AV46TFMedicamentoFormaFarm_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAMEDICACONCENTRACION") == 0 )
         {
            AV47TFRecetaMedicaConcentracion = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAMEDICACONCENTRACION_SEL") == 0 )
         {
            AV48TFRecetaMedicaConcentracion_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAMEDICACANTIDAD") == 0 )
         {
            AV49TFRecetaMedicaCantidad = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV50TFRecetaMedicaCantidad_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAMEDICAATENCION") == 0 )
         {
            AV51TFRecetaMedicaAtencion = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAMEDICAATENCION_SEL") == 0 )
         {
            AV52TFRecetaMedicaAtencion_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAMEDICAFLAG") == 0 )
         {
            AV55TFRecetaMedicaFlag = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV56TFRecetaMedicaFlag_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAINDICACIONES") == 0 )
         {
            AV58TFRecetaIndicaciones = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRECETAINDICACIONES_SEL") == 0 )
         {
            AV59TFRecetaIndicaciones_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV88GXV2 = (int)(AV88GXV2+1) ;
      }
   }

   public void S172( )
   {
      /* 'BEFOREWRITELINE' Routine */
      returnInSub = false ;
   }

   public void S182( )
   {
      /* 'AFTERWRITELINE' Routine */
      returnInSub = false ;
   }

   protected void cleanup( )
   {
      this.aP0[0] = recetamedicawwexport.this.AV12Filename;
      this.aP1[0] = recetamedicawwexport.this.AV13ErrorMessage;
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
      AV12Filename = "" ;
      AV13ErrorMessage = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV62Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV19FilterFullText = "" ;
      AV42TFMedicamentoCodigo_Sel = "" ;
      AV41TFMedicamentoCodigo = "" ;
      AV44TFMedicamentoNombre_Sel = "" ;
      AV43TFMedicamentoNombre = "" ;
      AV46TFMedicamentoFormaFarm_Sel = "" ;
      AV45TFMedicamentoFormaFarm = "" ;
      AV48TFRecetaMedicaConcentracion_Sel = "" ;
      AV47TFRecetaMedicaConcentracion = "" ;
      AV52TFRecetaMedicaAtencion_Sel = "" ;
      AV51TFRecetaMedicaAtencion = "" ;
      AV59TFRecetaIndicaciones_Sel = "" ;
      AV58TFRecetaIndicaciones = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A229MedicamentoCodigo = "" ;
      A230MedicamentoNombre = "" ;
      A231MedicamentoFormaFarm = "" ;
      A268RecetaMedicaConcentracion = "" ;
      A273RecetaMedicaAtencion = "" ;
      A332RecetaIndicaciones = "" ;
      AV65Recetamedicawwds_1_filterfulltext = "" ;
      AV72Recetamedicawwds_8_tfmedicamentocodigo = "" ;
      AV73Recetamedicawwds_9_tfmedicamentocodigo_sel = "" ;
      AV74Recetamedicawwds_10_tfmedicamentonombre = "" ;
      AV75Recetamedicawwds_11_tfmedicamentonombre_sel = "" ;
      AV76Recetamedicawwds_12_tfmedicamentoformafarm = "" ;
      AV77Recetamedicawwds_13_tfmedicamentoformafarm_sel = "" ;
      AV78Recetamedicawwds_14_tfrecetamedicaconcentracion = "" ;
      AV79Recetamedicawwds_15_tfrecetamedicaconcentracion_sel = "" ;
      AV82Recetamedicawwds_18_tfrecetamedicaatencion = "" ;
      AV83Recetamedicawwds_19_tfrecetamedicaatencion_sel = "" ;
      AV86Recetamedicawwds_22_tfrecetaindicaciones = "" ;
      AV87Recetamedicawwds_23_tfrecetaindicaciones_sel = "" ;
      scmdbuf = "" ;
      lV65Recetamedicawwds_1_filterfulltext = "" ;
      lV72Recetamedicawwds_8_tfmedicamentocodigo = "" ;
      lV74Recetamedicawwds_10_tfmedicamentonombre = "" ;
      lV76Recetamedicawwds_12_tfmedicamentoformafarm = "" ;
      lV78Recetamedicawwds_14_tfrecetamedicaconcentracion = "" ;
      lV82Recetamedicawwds_18_tfrecetamedicaatencion = "" ;
      lV86Recetamedicawwds_22_tfrecetaindicaciones = "" ;
      P004Z2_A272RecetaMedicaFlag = new byte[1] ;
      P004Z2_n272RecetaMedicaFlag = new boolean[] {false} ;
      P004Z2_A269RecetaMedicaCantidad = new short[1] ;
      P004Z2_n269RecetaMedicaCantidad = new boolean[] {false} ;
      P004Z2_A42MedicamentoId = new short[1] ;
      P004Z2_n42MedicamentoId = new boolean[] {false} ;
      P004Z2_A19CitaId = new int[1] ;
      P004Z2_A50RecetaMedicaId = new short[1] ;
      P004Z2_A332RecetaIndicaciones = new String[] {""} ;
      P004Z2_A273RecetaMedicaAtencion = new String[] {""} ;
      P004Z2_n273RecetaMedicaAtencion = new boolean[] {false} ;
      P004Z2_A268RecetaMedicaConcentracion = new String[] {""} ;
      P004Z2_n268RecetaMedicaConcentracion = new boolean[] {false} ;
      P004Z2_A231MedicamentoFormaFarm = new String[] {""} ;
      P004Z2_n231MedicamentoFormaFarm = new boolean[] {false} ;
      P004Z2_A230MedicamentoNombre = new String[] {""} ;
      P004Z2_A229MedicamentoCodigo = new String[] {""} ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.recetamedicawwexport__default(),
         new Object[] {
             new Object[] {
            P004Z2_A272RecetaMedicaFlag, P004Z2_n272RecetaMedicaFlag, P004Z2_A269RecetaMedicaCantidad, P004Z2_n269RecetaMedicaCantidad, P004Z2_A42MedicamentoId, P004Z2_n42MedicamentoId, P004Z2_A19CitaId, P004Z2_A50RecetaMedicaId, P004Z2_A332RecetaIndicaciones, P004Z2_A273RecetaMedicaAtencion,
            P004Z2_n273RecetaMedicaAtencion, P004Z2_A268RecetaMedicaConcentracion, P004Z2_n268RecetaMedicaConcentracion, P004Z2_A231MedicamentoFormaFarm, P004Z2_n231MedicamentoFormaFarm, P004Z2_A230MedicamentoNombre, P004Z2_A229MedicamentoCodigo
            }
         }
      );
      AV62Pgmname = "RecetaMedicaWWExport" ;
      /* GeneXus formulas. */
      AV62Pgmname = "RecetaMedicaWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV55TFRecetaMedicaFlag ;
   private byte AV56TFRecetaMedicaFlag_To ;
   private byte A272RecetaMedicaFlag ;
   private byte AV84Recetamedicawwds_20_tfrecetamedicaflag ;
   private byte AV85Recetamedicawwds_21_tfrecetamedicaflag_to ;
   private short AV35TFRecetaMedicaId ;
   private short AV36TFRecetaMedicaId_To ;
   private short AV39TFMedicamentoId ;
   private short AV40TFMedicamentoId_To ;
   private short AV49TFRecetaMedicaCantidad ;
   private short AV50TFRecetaMedicaCantidad_To ;
   private short GXv_int5[] ;
   private short A50RecetaMedicaId ;
   private short A42MedicamentoId ;
   private short A269RecetaMedicaCantidad ;
   private short AV66Recetamedicawwds_2_tfrecetamedicaid ;
   private short AV67Recetamedicawwds_3_tfrecetamedicaid_to ;
   private short AV70Recetamedicawwds_6_tfmedicamentoid ;
   private short AV71Recetamedicawwds_7_tfmedicamentoid_to ;
   private short AV80Recetamedicawwds_16_tfrecetamedicacantidad ;
   private short AV81Recetamedicawwds_17_tfrecetamedicacantidad_to ;
   private short AV17OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV37TFCitaId ;
   private int AV38TFCitaId_To ;
   private int AV63GXV1 ;
   private int A19CitaId ;
   private int AV68Recetamedicawwds_4_tfcitaid ;
   private int AV69Recetamedicawwds_5_tfcitaid_to ;
   private int AV88GXV2 ;
   private long AV32VisibleColumnCount ;
   private String AV62Pgmname ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV18OrderedDsc ;
   private boolean n272RecetaMedicaFlag ;
   private boolean n269RecetaMedicaCantidad ;
   private boolean n42MedicamentoId ;
   private boolean n273RecetaMedicaAtencion ;
   private boolean n268RecetaMedicaConcentracion ;
   private boolean n231MedicamentoFormaFarm ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV19FilterFullText ;
   private String AV42TFMedicamentoCodigo_Sel ;
   private String AV41TFMedicamentoCodigo ;
   private String AV44TFMedicamentoNombre_Sel ;
   private String AV43TFMedicamentoNombre ;
   private String AV46TFMedicamentoFormaFarm_Sel ;
   private String AV45TFMedicamentoFormaFarm ;
   private String AV48TFRecetaMedicaConcentracion_Sel ;
   private String AV47TFRecetaMedicaConcentracion ;
   private String AV52TFRecetaMedicaAtencion_Sel ;
   private String AV51TFRecetaMedicaAtencion ;
   private String AV59TFRecetaIndicaciones_Sel ;
   private String AV58TFRecetaIndicaciones ;
   private String A229MedicamentoCodigo ;
   private String A230MedicamentoNombre ;
   private String A231MedicamentoFormaFarm ;
   private String A268RecetaMedicaConcentracion ;
   private String A273RecetaMedicaAtencion ;
   private String A332RecetaIndicaciones ;
   private String AV65Recetamedicawwds_1_filterfulltext ;
   private String AV72Recetamedicawwds_8_tfmedicamentocodigo ;
   private String AV73Recetamedicawwds_9_tfmedicamentocodigo_sel ;
   private String AV74Recetamedicawwds_10_tfmedicamentonombre ;
   private String AV75Recetamedicawwds_11_tfmedicamentonombre_sel ;
   private String AV76Recetamedicawwds_12_tfmedicamentoformafarm ;
   private String AV77Recetamedicawwds_13_tfmedicamentoformafarm_sel ;
   private String AV78Recetamedicawwds_14_tfrecetamedicaconcentracion ;
   private String AV79Recetamedicawwds_15_tfrecetamedicaconcentracion_sel ;
   private String AV82Recetamedicawwds_18_tfrecetamedicaatencion ;
   private String AV83Recetamedicawwds_19_tfrecetamedicaatencion_sel ;
   private String AV86Recetamedicawwds_22_tfrecetaindicaciones ;
   private String AV87Recetamedicawwds_23_tfrecetaindicaciones_sel ;
   private String lV65Recetamedicawwds_1_filterfulltext ;
   private String lV72Recetamedicawwds_8_tfmedicamentocodigo ;
   private String lV74Recetamedicawwds_10_tfmedicamentonombre ;
   private String lV76Recetamedicawwds_12_tfmedicamentoformafarm ;
   private String lV78Recetamedicawwds_14_tfrecetamedicaconcentracion ;
   private String lV82Recetamedicawwds_18_tfrecetamedicaatencion ;
   private String lV86Recetamedicawwds_22_tfrecetaindicaciones ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private byte[] P004Z2_A272RecetaMedicaFlag ;
   private boolean[] P004Z2_n272RecetaMedicaFlag ;
   private short[] P004Z2_A269RecetaMedicaCantidad ;
   private boolean[] P004Z2_n269RecetaMedicaCantidad ;
   private short[] P004Z2_A42MedicamentoId ;
   private boolean[] P004Z2_n42MedicamentoId ;
   private int[] P004Z2_A19CitaId ;
   private short[] P004Z2_A50RecetaMedicaId ;
   private String[] P004Z2_A332RecetaIndicaciones ;
   private String[] P004Z2_A273RecetaMedicaAtencion ;
   private boolean[] P004Z2_n273RecetaMedicaAtencion ;
   private String[] P004Z2_A268RecetaMedicaConcentracion ;
   private boolean[] P004Z2_n268RecetaMedicaConcentracion ;
   private String[] P004Z2_A231MedicamentoFormaFarm ;
   private boolean[] P004Z2_n231MedicamentoFormaFarm ;
   private String[] P004Z2_A230MedicamentoNombre ;
   private String[] P004Z2_A229MedicamentoCodigo ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV24ColumnsSelector ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelectorAux ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column AV26ColumnsSelector_Column ;
}

final  class recetamedicawwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P004Z2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV65Recetamedicawwds_1_filterfulltext ,
                                          short AV66Recetamedicawwds_2_tfrecetamedicaid ,
                                          short AV67Recetamedicawwds_3_tfrecetamedicaid_to ,
                                          int AV68Recetamedicawwds_4_tfcitaid ,
                                          int AV69Recetamedicawwds_5_tfcitaid_to ,
                                          short AV70Recetamedicawwds_6_tfmedicamentoid ,
                                          short AV71Recetamedicawwds_7_tfmedicamentoid_to ,
                                          String AV73Recetamedicawwds_9_tfmedicamentocodigo_sel ,
                                          String AV72Recetamedicawwds_8_tfmedicamentocodigo ,
                                          String AV75Recetamedicawwds_11_tfmedicamentonombre_sel ,
                                          String AV74Recetamedicawwds_10_tfmedicamentonombre ,
                                          String AV77Recetamedicawwds_13_tfmedicamentoformafarm_sel ,
                                          String AV76Recetamedicawwds_12_tfmedicamentoformafarm ,
                                          String AV79Recetamedicawwds_15_tfrecetamedicaconcentracion_sel ,
                                          String AV78Recetamedicawwds_14_tfrecetamedicaconcentracion ,
                                          short AV80Recetamedicawwds_16_tfrecetamedicacantidad ,
                                          short AV81Recetamedicawwds_17_tfrecetamedicacantidad_to ,
                                          String AV83Recetamedicawwds_19_tfrecetamedicaatencion_sel ,
                                          String AV82Recetamedicawwds_18_tfrecetamedicaatencion ,
                                          byte AV84Recetamedicawwds_20_tfrecetamedicaflag ,
                                          byte AV85Recetamedicawwds_21_tfrecetamedicaflag_to ,
                                          String AV87Recetamedicawwds_23_tfrecetaindicaciones_sel ,
                                          String AV86Recetamedicawwds_22_tfrecetaindicaciones ,
                                          short A50RecetaMedicaId ,
                                          int A19CitaId ,
                                          short A42MedicamentoId ,
                                          String A229MedicamentoCodigo ,
                                          String A230MedicamentoNombre ,
                                          String A231MedicamentoFormaFarm ,
                                          String A268RecetaMedicaConcentracion ,
                                          short A269RecetaMedicaCantidad ,
                                          String A273RecetaMedicaAtencion ,
                                          byte A272RecetaMedicaFlag ,
                                          String A332RecetaIndicaciones ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[33];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T1.[RecetaMedicaFlag], T1.[RecetaMedicaCantidad], T1.[MedicamentoId], T1.[CitaId], T1.[RecetaMedicaId], T1.[RecetaIndicaciones], T1.[RecetaMedicaAtencion]," ;
      scmdbuf += " T1.[RecetaMedicaConcentracion], T2.[MedicamentoFormaFarm], T2.[MedicamentoNombre], T2.[MedicamentoCodigo] FROM ([RecetaMedica] T1 LEFT JOIN [Medicamento] T2 ON" ;
      scmdbuf += " T2.[MedicamentoId] = T1.[MedicamentoId])" ;
      if ( ! (GXutil.strcmp("", AV65Recetamedicawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[RecetaMedicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[MedicamentoId] AS decimal(4,0))) like '%' + ?) or ( T2.[MedicamentoCodigo] like '%' + ?) or ( T2.[MedicamentoNombre] like '%' + ?) or ( T2.[MedicamentoFormaFarm] like '%' + ?) or ( T1.[RecetaMedicaConcentracion] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[RecetaMedicaCantidad] AS decimal(4,0))) like '%' + ?) or ( T1.[RecetaMedicaAtencion] like '%' + ?) or ( CONVERT( char(1), CAST(T1.[RecetaMedicaFlag] AS decimal(1,0))) like '%' + ?) or ( T1.[RecetaIndicaciones] like '%' + ?))");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
         GXv_int10[1] = (byte)(1) ;
         GXv_int10[2] = (byte)(1) ;
         GXv_int10[3] = (byte)(1) ;
         GXv_int10[4] = (byte)(1) ;
         GXv_int10[5] = (byte)(1) ;
         GXv_int10[6] = (byte)(1) ;
         GXv_int10[7] = (byte)(1) ;
         GXv_int10[8] = (byte)(1) ;
         GXv_int10[9] = (byte)(1) ;
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ! (0==AV66Recetamedicawwds_2_tfrecetamedicaid) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaId] >= ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( ! (0==AV67Recetamedicawwds_3_tfrecetamedicaid_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaId] <= ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( ! (0==AV68Recetamedicawwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( ! (0==AV69Recetamedicawwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int10[14] = (byte)(1) ;
      }
      if ( ! (0==AV70Recetamedicawwds_6_tfmedicamentoid) )
      {
         addWhere(sWhereString, "(T1.[MedicamentoId] >= ?)");
      }
      else
      {
         GXv_int10[15] = (byte)(1) ;
      }
      if ( ! (0==AV71Recetamedicawwds_7_tfmedicamentoid_to) )
      {
         addWhere(sWhereString, "(T1.[MedicamentoId] <= ?)");
      }
      else
      {
         GXv_int10[16] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV73Recetamedicawwds_9_tfmedicamentocodigo_sel)==0) && ( ! (GXutil.strcmp("", AV72Recetamedicawwds_8_tfmedicamentocodigo)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoCodigo] like ?)");
      }
      else
      {
         GXv_int10[17] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV73Recetamedicawwds_9_tfmedicamentocodigo_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoCodigo] = ?)");
      }
      else
      {
         GXv_int10[18] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV75Recetamedicawwds_11_tfmedicamentonombre_sel)==0) && ( ! (GXutil.strcmp("", AV74Recetamedicawwds_10_tfmedicamentonombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoNombre] like ?)");
      }
      else
      {
         GXv_int10[19] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV75Recetamedicawwds_11_tfmedicamentonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoNombre] = ?)");
      }
      else
      {
         GXv_int10[20] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV77Recetamedicawwds_13_tfmedicamentoformafarm_sel)==0) && ( ! (GXutil.strcmp("", AV76Recetamedicawwds_12_tfmedicamentoformafarm)==0) ) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoFormaFarm] like ?)");
      }
      else
      {
         GXv_int10[21] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV77Recetamedicawwds_13_tfmedicamentoformafarm_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[MedicamentoFormaFarm] = ?)");
      }
      else
      {
         GXv_int10[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV79Recetamedicawwds_15_tfrecetamedicaconcentracion_sel)==0) && ( ! (GXutil.strcmp("", AV78Recetamedicawwds_14_tfrecetamedicaconcentracion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaConcentracion] like ?)");
      }
      else
      {
         GXv_int10[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV79Recetamedicawwds_15_tfrecetamedicaconcentracion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaConcentracion] = ?)");
      }
      else
      {
         GXv_int10[24] = (byte)(1) ;
      }
      if ( ! (0==AV80Recetamedicawwds_16_tfrecetamedicacantidad) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaCantidad] >= ?)");
      }
      else
      {
         GXv_int10[25] = (byte)(1) ;
      }
      if ( ! (0==AV81Recetamedicawwds_17_tfrecetamedicacantidad_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaCantidad] <= ?)");
      }
      else
      {
         GXv_int10[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV83Recetamedicawwds_19_tfrecetamedicaatencion_sel)==0) && ( ! (GXutil.strcmp("", AV82Recetamedicawwds_18_tfrecetamedicaatencion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaAtencion] like ?)");
      }
      else
      {
         GXv_int10[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV83Recetamedicawwds_19_tfrecetamedicaatencion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaAtencion] = ?)");
      }
      else
      {
         GXv_int10[28] = (byte)(1) ;
      }
      if ( ! (0==AV84Recetamedicawwds_20_tfrecetamedicaflag) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaFlag] >= ?)");
      }
      else
      {
         GXv_int10[29] = (byte)(1) ;
      }
      if ( ! (0==AV85Recetamedicawwds_21_tfrecetamedicaflag_to) )
      {
         addWhere(sWhereString, "(T1.[RecetaMedicaFlag] <= ?)");
      }
      else
      {
         GXv_int10[30] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV87Recetamedicawwds_23_tfrecetaindicaciones_sel)==0) && ( ! (GXutil.strcmp("", AV86Recetamedicawwds_22_tfrecetaindicaciones)==0) ) )
      {
         addWhere(sWhereString, "(T1.[RecetaIndicaciones] like ?)");
      }
      else
      {
         GXv_int10[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV87Recetamedicawwds_23_tfrecetaindicaciones_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[RecetaIndicaciones] = ?)");
      }
      else
      {
         GXv_int10[32] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[RecetaMedicaConcentracion]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[RecetaMedicaConcentracion] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[RecetaMedicaId]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[RecetaMedicaId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[CitaId]" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[CitaId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[MedicamentoId]" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[MedicamentoId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[MedicamentoCodigo]" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[MedicamentoCodigo] DESC" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[MedicamentoNombre]" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[MedicamentoNombre] DESC" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[MedicamentoFormaFarm]" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[MedicamentoFormaFarm] DESC" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[RecetaMedicaCantidad]" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[RecetaMedicaCantidad] DESC" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[RecetaMedicaAtencion]" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[RecetaMedicaAtencion] DESC" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[RecetaMedicaFlag]" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[RecetaMedicaFlag] DESC" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[RecetaIndicaciones]" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[RecetaIndicaciones] DESC" ;
      }
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P004Z2(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).byteValue() , (String)dynConstraints[21] , (String)dynConstraints[22] , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).shortValue() , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , (String)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , (String)dynConstraints[33] , ((Number) dynConstraints[34]).shortValue() , ((Boolean) dynConstraints[35]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004Z2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((short[]) buf[4])[0] = rslt.getShort(3);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(4);
               ((short[]) buf[7])[0] = rslt.getShort(5);
               ((String[]) buf[8])[0] = rslt.getVarchar(6);
               ((String[]) buf[9])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getVarchar(10);
               ((String[]) buf[16])[0] = rslt.getVarchar(11);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[44]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[45]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[46]).intValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[47]).intValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[48]).shortValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[49]).shortValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 15);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 15);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 40);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 40);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 40);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 40);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[58]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[59]).shortValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 40);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 40);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[62]).byteValue());
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[63]).byteValue());
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 300);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 300);
               }
               return;
      }
   }

}

