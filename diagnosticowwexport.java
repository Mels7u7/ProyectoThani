package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class diagnosticowwexport extends GXProcedure
{
   public diagnosticowwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( diagnosticowwexport.class ), "" );
   }

   public diagnosticowwexport( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      diagnosticowwexport.this.aP1 = new String[] {""};
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
      diagnosticowwexport.this.aP0 = aP0;
      diagnosticowwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDiagnostico", GXv_boolean2) ;
      diagnosticowwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV52Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "DiagnosticoWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
         diagnosticowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV19FilterFullText, GXv_char7) ;
         diagnosticowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      if ( ! ( (0==AV35TFDiagnosticoId) && (0==AV36TFDiagnosticoId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         diagnosticowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFDiagnosticoId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         diagnosticowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFDiagnosticoId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV38TFDiagnosticoCodigo_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Codigo") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         diagnosticowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFDiagnosticoCodigo_Sel, GXv_char7) ;
         diagnosticowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV37TFDiagnosticoCodigo)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Codigo") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            diagnosticowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV37TFDiagnosticoCodigo, GXv_char7) ;
            diagnosticowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV40TFDiagnosticoDescripcion_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Descripcion") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         diagnosticowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFDiagnosticoDescripcion_Sel, GXv_char7) ;
         diagnosticowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV39TFDiagnosticoDescripcion)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Descripcion") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            diagnosticowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV39TFDiagnosticoDescripcion, GXv_char7) ;
            diagnosticowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV42TFDiagnosticoTipoSexo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Tipo Sexo") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         diagnosticowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV49i = 1 ;
         AV53GXV1 = 1 ;
         while ( AV53GXV1 <= AV42TFDiagnosticoTipoSexo_Sels.size() )
         {
            AV43TFDiagnosticoTipoSexo_Sel = (String)AV42TFDiagnosticoTipoSexo_Sels.elementAt(-1+AV53GXV1) ;
            if ( AV49i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomaintiposexodiagnostico.getDescription(httpContext,(String)AV43TFDiagnosticoTipoSexo_Sel) );
            AV49i = (long)(AV49i+1) ;
            AV53GXV1 = (int)(AV53GXV1+1) ;
         }
      }
      if ( ! ( ( AV45TFDiagnosticoEstado_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Estado") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         diagnosticowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV49i = 1 ;
         AV54GXV2 = 1 ;
         while ( AV54GXV2 <= AV45TFDiagnosticoEstado_Sels.size() )
         {
            AV46TFDiagnosticoEstado_Sel = (String)AV45TFDiagnosticoEstado_Sels.elementAt(-1+AV54GXV2) ;
            if ( AV49i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomainestado.getDescription(httpContext,(String)AV46TFDiagnosticoEstado_Sel) );
            AV49i = (long)(AV49i+1) ;
            AV54GXV2 = (int)(AV54GXV2+1) ;
         }
      }
      if ( ! ( (GXutil.strcmp("", AV48TFDiagnosticoLongDesc_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Long Desc") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         diagnosticowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV48TFDiagnosticoLongDesc_Sel, GXv_char7) ;
         diagnosticowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV47TFDiagnosticoLongDesc)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Long Desc") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            diagnosticowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV47TFDiagnosticoLongDesc, GXv_char7) ;
            diagnosticowwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("DiagnosticoWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("DiagnosticoWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV55GXV3 = 1 ;
      while ( AV55GXV3 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV55GXV3));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV55GXV3 = (int)(AV55GXV3+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV57Diagnosticowwds_1_filterfulltext = AV19FilterFullText ;
      AV58Diagnosticowwds_2_tfdiagnosticoid = AV35TFDiagnosticoId ;
      AV59Diagnosticowwds_3_tfdiagnosticoid_to = AV36TFDiagnosticoId_To ;
      AV60Diagnosticowwds_4_tfdiagnosticocodigo = AV37TFDiagnosticoCodigo ;
      AV61Diagnosticowwds_5_tfdiagnosticocodigo_sel = AV38TFDiagnosticoCodigo_Sel ;
      AV62Diagnosticowwds_6_tfdiagnosticodescripcion = AV39TFDiagnosticoDescripcion ;
      AV63Diagnosticowwds_7_tfdiagnosticodescripcion_sel = AV40TFDiagnosticoDescripcion_Sel ;
      AV64Diagnosticowwds_8_tfdiagnosticotiposexo_sels = AV42TFDiagnosticoTipoSexo_Sels ;
      AV65Diagnosticowwds_9_tfdiagnosticoestado_sels = AV45TFDiagnosticoEstado_Sels ;
      AV66Diagnosticowwds_10_tfdiagnosticolongdesc = AV47TFDiagnosticoLongDesc ;
      AV67Diagnosticowwds_11_tfdiagnosticolongdesc_sel = AV48TFDiagnosticoLongDesc_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A130DiagnosticoTipoSexo ,
                                           AV64Diagnosticowwds_8_tfdiagnosticotiposexo_sels ,
                                           A131DiagnosticoEstado ,
                                           AV65Diagnosticowwds_9_tfdiagnosticoestado_sels ,
                                           AV57Diagnosticowwds_1_filterfulltext ,
                                           Integer.valueOf(AV58Diagnosticowwds_2_tfdiagnosticoid) ,
                                           Integer.valueOf(AV59Diagnosticowwds_3_tfdiagnosticoid_to) ,
                                           AV61Diagnosticowwds_5_tfdiagnosticocodigo_sel ,
                                           AV60Diagnosticowwds_4_tfdiagnosticocodigo ,
                                           AV63Diagnosticowwds_7_tfdiagnosticodescripcion_sel ,
                                           AV62Diagnosticowwds_6_tfdiagnosticodescripcion ,
                                           Integer.valueOf(AV64Diagnosticowwds_8_tfdiagnosticotiposexo_sels.size()) ,
                                           Integer.valueOf(AV65Diagnosticowwds_9_tfdiagnosticoestado_sels.size()) ,
                                           AV67Diagnosticowwds_11_tfdiagnosticolongdesc_sel ,
                                           AV66Diagnosticowwds_10_tfdiagnosticolongdesc ,
                                           Integer.valueOf(A23DiagnosticoId) ,
                                           A107DiagnosticoCodigo ,
                                           A108DiagnosticoDescripcion ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV57Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV57Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV57Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV57Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV57Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV57Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV57Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV57Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV57Diagnosticowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Diagnosticowwds_1_filterfulltext), "%", "") ;
      lV60Diagnosticowwds_4_tfdiagnosticocodigo = GXutil.concat( GXutil.rtrim( AV60Diagnosticowwds_4_tfdiagnosticocodigo), "%", "") ;
      lV62Diagnosticowwds_6_tfdiagnosticodescripcion = GXutil.concat( GXutil.rtrim( AV62Diagnosticowwds_6_tfdiagnosticodescripcion), "%", "") ;
      lV66Diagnosticowwds_10_tfdiagnosticolongdesc = GXutil.concat( GXutil.rtrim( AV66Diagnosticowwds_10_tfdiagnosticolongdesc), "%", "") ;
      /* Using cursor P00432 */
      pr_default.execute(0, new Object[] {lV57Diagnosticowwds_1_filterfulltext, lV57Diagnosticowwds_1_filterfulltext, lV57Diagnosticowwds_1_filterfulltext, lV57Diagnosticowwds_1_filterfulltext, lV57Diagnosticowwds_1_filterfulltext, lV57Diagnosticowwds_1_filterfulltext, lV57Diagnosticowwds_1_filterfulltext, lV57Diagnosticowwds_1_filterfulltext, lV57Diagnosticowwds_1_filterfulltext, Integer.valueOf(AV58Diagnosticowwds_2_tfdiagnosticoid), Integer.valueOf(AV59Diagnosticowwds_3_tfdiagnosticoid_to), lV60Diagnosticowwds_4_tfdiagnosticocodigo, AV61Diagnosticowwds_5_tfdiagnosticocodigo_sel, lV62Diagnosticowwds_6_tfdiagnosticodescripcion, AV63Diagnosticowwds_7_tfdiagnosticodescripcion_sel, lV66Diagnosticowwds_10_tfdiagnosticolongdesc, AV67Diagnosticowwds_11_tfdiagnosticolongdesc_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A23DiagnosticoId = P00432_A23DiagnosticoId[0] ;
         A131DiagnosticoEstado = P00432_A131DiagnosticoEstado[0] ;
         A130DiagnosticoTipoSexo = P00432_A130DiagnosticoTipoSexo[0] ;
         A108DiagnosticoDescripcion = P00432_A108DiagnosticoDescripcion[0] ;
         A107DiagnosticoCodigo = P00432_A107DiagnosticoCodigo[0] ;
         A132DiagnosticoLongDesc = A107DiagnosticoCodigo + " - " + A108DiagnosticoDescripcion ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV32VisibleColumnCount = 0 ;
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A23DiagnosticoId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A107DiagnosticoCodigo, GXv_char7) ;
            diagnosticowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A108DiagnosticoDescripcion, GXv_char7) ;
            diagnosticowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomaintiposexodiagnostico.getDescription(httpContext,(String)A130DiagnosticoTipoSexo) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomainestado.getDescription(httpContext,(String)A131DiagnosticoEstado) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A132DiagnosticoLongDesc, GXv_char7) ;
            diagnosticowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S182 ();
         if ( returnInSub )
         {
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
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "DiagnosticoId", "", "Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "DiagnosticoCodigo", "", "Codigo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "DiagnosticoDescripcion", "", "Descripcion", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "DiagnosticoTipoSexo", "", "Tipo Sexo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "DiagnosticoEstado", "", "Estado", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "DiagnosticoLongDesc", "", "Long Desc", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV28UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "DiagnosticoWWColumnsSelector", GXv_char7) ;
      diagnosticowwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("DiagnosticoWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "DiagnosticoWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("DiagnosticoWWGridState"), null, null);
      }
      AV17OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV18OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV68GXV4 = 1 ;
      while ( AV68GXV4 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV68GXV4));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV19FilterFullText = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDIAGNOSTICOID") == 0 )
         {
            AV35TFDiagnosticoId = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFDiagnosticoId_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDIAGNOSTICOCODIGO") == 0 )
         {
            AV37TFDiagnosticoCodigo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDIAGNOSTICOCODIGO_SEL") == 0 )
         {
            AV38TFDiagnosticoCodigo_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDIAGNOSTICODESCRIPCION") == 0 )
         {
            AV39TFDiagnosticoDescripcion = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDIAGNOSTICODESCRIPCION_SEL") == 0 )
         {
            AV40TFDiagnosticoDescripcion_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDIAGNOSTICOTIPOSEXO_SEL") == 0 )
         {
            AV41TFDiagnosticoTipoSexo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV42TFDiagnosticoTipoSexo_Sels.fromJSonString(AV41TFDiagnosticoTipoSexo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDIAGNOSTICOESTADO_SEL") == 0 )
         {
            AV44TFDiagnosticoEstado_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV45TFDiagnosticoEstado_Sels.fromJSonString(AV44TFDiagnosticoEstado_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDIAGNOSTICOLONGDESC") == 0 )
         {
            AV47TFDiagnosticoLongDesc = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDIAGNOSTICOLONGDESC_SEL") == 0 )
         {
            AV48TFDiagnosticoLongDesc_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV68GXV4 = (int)(AV68GXV4+1) ;
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
      this.aP0[0] = diagnosticowwexport.this.AV12Filename;
      this.aP1[0] = diagnosticowwexport.this.AV13ErrorMessage;
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
      AV52Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV19FilterFullText = "" ;
      AV38TFDiagnosticoCodigo_Sel = "" ;
      AV37TFDiagnosticoCodigo = "" ;
      AV40TFDiagnosticoDescripcion_Sel = "" ;
      AV39TFDiagnosticoDescripcion = "" ;
      AV42TFDiagnosticoTipoSexo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43TFDiagnosticoTipoSexo_Sel = "" ;
      AV45TFDiagnosticoEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV46TFDiagnosticoEstado_Sel = "" ;
      AV48TFDiagnosticoLongDesc_Sel = "" ;
      AV47TFDiagnosticoLongDesc = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A107DiagnosticoCodigo = "" ;
      A108DiagnosticoDescripcion = "" ;
      A130DiagnosticoTipoSexo = "" ;
      A131DiagnosticoEstado = "" ;
      A132DiagnosticoLongDesc = "" ;
      AV57Diagnosticowwds_1_filterfulltext = "" ;
      AV60Diagnosticowwds_4_tfdiagnosticocodigo = "" ;
      AV61Diagnosticowwds_5_tfdiagnosticocodigo_sel = "" ;
      AV62Diagnosticowwds_6_tfdiagnosticodescripcion = "" ;
      AV63Diagnosticowwds_7_tfdiagnosticodescripcion_sel = "" ;
      AV64Diagnosticowwds_8_tfdiagnosticotiposexo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV65Diagnosticowwds_9_tfdiagnosticoestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV66Diagnosticowwds_10_tfdiagnosticolongdesc = "" ;
      AV67Diagnosticowwds_11_tfdiagnosticolongdesc_sel = "" ;
      scmdbuf = "" ;
      lV57Diagnosticowwds_1_filterfulltext = "" ;
      lV60Diagnosticowwds_4_tfdiagnosticocodigo = "" ;
      lV62Diagnosticowwds_6_tfdiagnosticodescripcion = "" ;
      lV66Diagnosticowwds_10_tfdiagnosticolongdesc = "" ;
      P00432_A23DiagnosticoId = new int[1] ;
      P00432_A131DiagnosticoEstado = new String[] {""} ;
      P00432_A130DiagnosticoTipoSexo = new String[] {""} ;
      P00432_A108DiagnosticoDescripcion = new String[] {""} ;
      P00432_A107DiagnosticoCodigo = new String[] {""} ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV41TFDiagnosticoTipoSexo_SelsJson = "" ;
      AV44TFDiagnosticoEstado_SelsJson = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.diagnosticowwexport__default(),
         new Object[] {
             new Object[] {
            P00432_A23DiagnosticoId, P00432_A131DiagnosticoEstado, P00432_A130DiagnosticoTipoSexo, P00432_A108DiagnosticoDescripcion, P00432_A107DiagnosticoCodigo
            }
         }
      );
      AV52Pgmname = "DiagnosticoWWExport" ;
      /* GeneXus formulas. */
      AV52Pgmname = "DiagnosticoWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short GXv_int5[] ;
   private short AV17OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV35TFDiagnosticoId ;
   private int AV36TFDiagnosticoId_To ;
   private int AV53GXV1 ;
   private int AV54GXV2 ;
   private int AV55GXV3 ;
   private int A23DiagnosticoId ;
   private int AV58Diagnosticowwds_2_tfdiagnosticoid ;
   private int AV59Diagnosticowwds_3_tfdiagnosticoid_to ;
   private int AV64Diagnosticowwds_8_tfdiagnosticotiposexo_sels_size ;
   private int AV65Diagnosticowwds_9_tfdiagnosticoestado_sels_size ;
   private int AV68GXV4 ;
   private long AV49i ;
   private long AV32VisibleColumnCount ;
   private String AV52Pgmname ;
   private String AV43TFDiagnosticoTipoSexo_Sel ;
   private String AV46TFDiagnosticoEstado_Sel ;
   private String A130DiagnosticoTipoSexo ;
   private String A131DiagnosticoEstado ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV18OrderedDsc ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV41TFDiagnosticoTipoSexo_SelsJson ;
   private String AV44TFDiagnosticoEstado_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV19FilterFullText ;
   private String AV38TFDiagnosticoCodigo_Sel ;
   private String AV37TFDiagnosticoCodigo ;
   private String AV40TFDiagnosticoDescripcion_Sel ;
   private String AV39TFDiagnosticoDescripcion ;
   private String AV48TFDiagnosticoLongDesc_Sel ;
   private String AV47TFDiagnosticoLongDesc ;
   private String A107DiagnosticoCodigo ;
   private String A108DiagnosticoDescripcion ;
   private String A132DiagnosticoLongDesc ;
   private String AV57Diagnosticowwds_1_filterfulltext ;
   private String AV60Diagnosticowwds_4_tfdiagnosticocodigo ;
   private String AV61Diagnosticowwds_5_tfdiagnosticocodigo_sel ;
   private String AV62Diagnosticowwds_6_tfdiagnosticodescripcion ;
   private String AV63Diagnosticowwds_7_tfdiagnosticodescripcion_sel ;
   private String AV66Diagnosticowwds_10_tfdiagnosticolongdesc ;
   private String AV67Diagnosticowwds_11_tfdiagnosticolongdesc_sel ;
   private String lV57Diagnosticowwds_1_filterfulltext ;
   private String lV60Diagnosticowwds_4_tfdiagnosticocodigo ;
   private String lV62Diagnosticowwds_6_tfdiagnosticodescripcion ;
   private String lV66Diagnosticowwds_10_tfdiagnosticolongdesc ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV42TFDiagnosticoTipoSexo_Sels ;
   private GXSimpleCollection<String> AV45TFDiagnosticoEstado_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private int[] P00432_A23DiagnosticoId ;
   private String[] P00432_A131DiagnosticoEstado ;
   private String[] P00432_A130DiagnosticoTipoSexo ;
   private String[] P00432_A108DiagnosticoDescripcion ;
   private String[] P00432_A107DiagnosticoCodigo ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV64Diagnosticowwds_8_tfdiagnosticotiposexo_sels ;
   private GXSimpleCollection<String> AV65Diagnosticowwds_9_tfdiagnosticoestado_sels ;
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

final  class diagnosticowwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00432( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A130DiagnosticoTipoSexo ,
                                          GXSimpleCollection<String> AV64Diagnosticowwds_8_tfdiagnosticotiposexo_sels ,
                                          String A131DiagnosticoEstado ,
                                          GXSimpleCollection<String> AV65Diagnosticowwds_9_tfdiagnosticoestado_sels ,
                                          String AV57Diagnosticowwds_1_filterfulltext ,
                                          int AV58Diagnosticowwds_2_tfdiagnosticoid ,
                                          int AV59Diagnosticowwds_3_tfdiagnosticoid_to ,
                                          String AV61Diagnosticowwds_5_tfdiagnosticocodigo_sel ,
                                          String AV60Diagnosticowwds_4_tfdiagnosticocodigo ,
                                          String AV63Diagnosticowwds_7_tfdiagnosticodescripcion_sel ,
                                          String AV62Diagnosticowwds_6_tfdiagnosticodescripcion ,
                                          int AV64Diagnosticowwds_8_tfdiagnosticotiposexo_sels_size ,
                                          int AV65Diagnosticowwds_9_tfdiagnosticoestado_sels_size ,
                                          String AV67Diagnosticowwds_11_tfdiagnosticolongdesc_sel ,
                                          String AV66Diagnosticowwds_10_tfdiagnosticolongdesc ,
                                          int A23DiagnosticoId ,
                                          String A107DiagnosticoCodigo ,
                                          String A108DiagnosticoDescripcion ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[17];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT [DiagnosticoId], [DiagnosticoEstado], [DiagnosticoTipoSexo], [DiagnosticoDescripcion], [DiagnosticoCodigo] FROM [Diagnostico]" ;
      if ( ! (GXutil.strcmp("", AV57Diagnosticowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST([DiagnosticoId] AS decimal(8,0))) like '%' + ?) or ( [DiagnosticoCodigo] like '%' + ?) or ( [DiagnosticoDescripcion] like '%' + ?) or ( 'masculino' like '%' + LOWER(?) and [DiagnosticoTipoSexo] = 'M') or ( 'femenino' like '%' + LOWER(?) and [DiagnosticoTipoSexo] = 'F') or ( 'ambos' like '%' + LOWER(?) and [DiagnosticoTipoSexo] = 'A') or ( 'activo' like '%' + LOWER(?) and [DiagnosticoEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [DiagnosticoEstado] = 'I') or ( [DiagnosticoCodigo] + ' - ' + [DiagnosticoDescripcion] like '%' + ?))");
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
      }
      if ( ! (0==AV58Diagnosticowwds_2_tfdiagnosticoid) )
      {
         addWhere(sWhereString, "([DiagnosticoId] >= ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( ! (0==AV59Diagnosticowwds_3_tfdiagnosticoid_to) )
      {
         addWhere(sWhereString, "([DiagnosticoId] <= ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV61Diagnosticowwds_5_tfdiagnosticocodigo_sel)==0) && ( ! (GXutil.strcmp("", AV60Diagnosticowwds_4_tfdiagnosticocodigo)==0) ) )
      {
         addWhere(sWhereString, "([DiagnosticoCodigo] like ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV61Diagnosticowwds_5_tfdiagnosticocodigo_sel)==0) )
      {
         addWhere(sWhereString, "([DiagnosticoCodigo] = ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV63Diagnosticowwds_7_tfdiagnosticodescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV62Diagnosticowwds_6_tfdiagnosticodescripcion)==0) ) )
      {
         addWhere(sWhereString, "([DiagnosticoDescripcion] like ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV63Diagnosticowwds_7_tfdiagnosticodescripcion_sel)==0) )
      {
         addWhere(sWhereString, "([DiagnosticoDescripcion] = ?)");
      }
      else
      {
         GXv_int10[14] = (byte)(1) ;
      }
      if ( AV64Diagnosticowwds_8_tfdiagnosticotiposexo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV64Diagnosticowwds_8_tfdiagnosticotiposexo_sels, "[DiagnosticoTipoSexo] IN (", ")")+")");
      }
      if ( AV65Diagnosticowwds_9_tfdiagnosticoestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV65Diagnosticowwds_9_tfdiagnosticoestado_sels, "[DiagnosticoEstado] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV67Diagnosticowwds_11_tfdiagnosticolongdesc_sel)==0) && ( ! (GXutil.strcmp("", AV66Diagnosticowwds_10_tfdiagnosticolongdesc)==0) ) )
      {
         addWhere(sWhereString, "([DiagnosticoCodigo] + ' - ' + [DiagnosticoDescripcion] like ?)");
      }
      else
      {
         GXv_int10[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV67Diagnosticowwds_11_tfdiagnosticolongdesc_sel)==0) )
      {
         addWhere(sWhereString, "([DiagnosticoCodigo] + ' - ' + [DiagnosticoDescripcion] = ?)");
      }
      else
      {
         GXv_int10[16] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [DiagnosticoCodigo]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [DiagnosticoCodigo] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [DiagnosticoId]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [DiagnosticoId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [DiagnosticoDescripcion]" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [DiagnosticoDescripcion] DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [DiagnosticoTipoSexo]" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [DiagnosticoTipoSexo] DESC" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [DiagnosticoEstado]" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [DiagnosticoEstado] DESC" ;
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
                  return conditional_P00432(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , (String)dynConstraints[17] , ((Number) dynConstraints[18]).shortValue() , ((Boolean) dynConstraints[19]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00432", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
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
                  stmt.setVarchar(sIdx, (String)parms[17], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[26]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[27]).intValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 40);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 40);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 1000);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 1000);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 300);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 300);
               }
               return;
      }
   }

}

