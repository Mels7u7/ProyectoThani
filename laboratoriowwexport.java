package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class laboratoriowwexport extends GXProcedure
{
   public laboratoriowwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( laboratoriowwexport.class ), "" );
   }

   public laboratoriowwexport( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      laboratoriowwexport.this.aP1 = new String[] {""};
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
      laboratoriowwexport.this.aP0 = aP0;
      laboratoriowwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLaboratorio", GXv_boolean2) ;
      laboratoriowwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV54Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "LaboratorioWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
         laboratoriowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV19FilterFullText, GXv_char7) ;
         laboratoriowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      if ( ! ( (0==AV35TFLaboratorioId) && (0==AV36TFLaboratorioId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         laboratoriowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFLaboratorioId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         laboratoriowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFLaboratorioId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV38TFLaboratorioNombre_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nombre") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         laboratoriowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFLaboratorioNombre_Sel, GXv_char7) ;
         laboratoriowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV37TFLaboratorioNombre)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nombre") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            laboratoriowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV37TFLaboratorioNombre, GXv_char7) ;
            laboratoriowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV40TFLaboratorioDescripcion_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Descripcion") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         laboratoriowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFLaboratorioDescripcion_Sel, GXv_char7) ;
         laboratoriowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV39TFLaboratorioDescripcion)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Descripcion") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            laboratoriowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV39TFLaboratorioDescripcion, GXv_char7) ;
            laboratoriowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV42TFLaboratorioTipoDocumento_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Tipo Documento") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         laboratoriowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV51i = 1 ;
         AV55GXV1 = 1 ;
         while ( AV55GXV1 <= AV42TFLaboratorioTipoDocumento_Sels.size() )
         {
            AV43TFLaboratorioTipoDocumento_Sel = (String)AV42TFLaboratorioTipoDocumento_Sels.elementAt(-1+AV55GXV1) ;
            if ( AV51i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomaintipodocumentolaboratorio.getDescription(httpContext,(String)AV43TFLaboratorioTipoDocumento_Sel) );
            AV51i = (long)(AV51i+1) ;
            AV55GXV1 = (int)(AV55GXV1+1) ;
         }
      }
      if ( ! ( (GXutil.strcmp("", AV45TFLaboratorioNroDocumento_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nro Documento") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         laboratoriowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV45TFLaboratorioNroDocumento_Sel, GXv_char7) ;
         laboratoriowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV44TFLaboratorioNroDocumento)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nro Documento") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            laboratoriowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV44TFLaboratorioNroDocumento, GXv_char7) ;
            laboratoriowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV46TFLaboratorioComision) && (0==AV47TFLaboratorioComision_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Comision") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         laboratoriowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV46TFLaboratorioComision );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         laboratoriowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV47TFLaboratorioComision_To );
      }
      if ( ! ( ( AV49TFLaboratorioEstado_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Estado") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         laboratoriowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV51i = 1 ;
         AV56GXV2 = 1 ;
         while ( AV56GXV2 <= AV49TFLaboratorioEstado_Sels.size() )
         {
            AV50TFLaboratorioEstado_Sel = (String)AV49TFLaboratorioEstado_Sels.elementAt(-1+AV56GXV2) ;
            if ( AV51i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomainestado.getDescription(httpContext,(String)AV50TFLaboratorioEstado_Sel) );
            AV51i = (long)(AV51i+1) ;
            AV56GXV2 = (int)(AV56GXV2+1) ;
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("LaboratorioWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("LaboratorioWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV57GXV3 = 1 ;
      while ( AV57GXV3 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV57GXV3));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV57GXV3 = (int)(AV57GXV3+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV59Laboratoriowwds_1_filterfulltext = AV19FilterFullText ;
      AV60Laboratoriowwds_2_tflaboratorioid = AV35TFLaboratorioId ;
      AV61Laboratoriowwds_3_tflaboratorioid_to = AV36TFLaboratorioId_To ;
      AV62Laboratoriowwds_4_tflaboratorionombre = AV37TFLaboratorioNombre ;
      AV63Laboratoriowwds_5_tflaboratorionombre_sel = AV38TFLaboratorioNombre_Sel ;
      AV64Laboratoriowwds_6_tflaboratoriodescripcion = AV39TFLaboratorioDescripcion ;
      AV65Laboratoriowwds_7_tflaboratoriodescripcion_sel = AV40TFLaboratorioDescripcion_Sel ;
      AV66Laboratoriowwds_8_tflaboratoriotipodocumento_sels = AV42TFLaboratorioTipoDocumento_Sels ;
      AV67Laboratoriowwds_9_tflaboratorionrodocumento = AV44TFLaboratorioNroDocumento ;
      AV68Laboratoriowwds_10_tflaboratorionrodocumento_sel = AV45TFLaboratorioNroDocumento_Sel ;
      AV69Laboratoriowwds_11_tflaboratoriocomision = AV46TFLaboratorioComision ;
      AV70Laboratoriowwds_12_tflaboratoriocomision_to = AV47TFLaboratorioComision_To ;
      AV71Laboratoriowwds_13_tflaboratorioestado_sels = AV49TFLaboratorioEstado_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A167LaboratorioTipoDocumento ,
                                           AV66Laboratoriowwds_8_tflaboratoriotipodocumento_sels ,
                                           A171LaboratorioEstado ,
                                           AV71Laboratoriowwds_13_tflaboratorioestado_sels ,
                                           AV59Laboratoriowwds_1_filterfulltext ,
                                           Short.valueOf(AV60Laboratoriowwds_2_tflaboratorioid) ,
                                           Short.valueOf(AV61Laboratoriowwds_3_tflaboratorioid_to) ,
                                           AV63Laboratoriowwds_5_tflaboratorionombre_sel ,
                                           AV62Laboratoriowwds_4_tflaboratorionombre ,
                                           AV65Laboratoriowwds_7_tflaboratoriodescripcion_sel ,
                                           AV64Laboratoriowwds_6_tflaboratoriodescripcion ,
                                           Integer.valueOf(AV66Laboratoriowwds_8_tflaboratoriotipodocumento_sels.size()) ,
                                           AV68Laboratoriowwds_10_tflaboratorionrodocumento_sel ,
                                           AV67Laboratoriowwds_9_tflaboratorionrodocumento ,
                                           Short.valueOf(AV69Laboratoriowwds_11_tflaboratoriocomision) ,
                                           Short.valueOf(AV70Laboratoriowwds_12_tflaboratoriocomision_to) ,
                                           Integer.valueOf(AV71Laboratoriowwds_13_tflaboratorioestado_sels.size()) ,
                                           Short.valueOf(A40LaboratorioId) ,
                                           A165LaboratorioNombre ,
                                           A166LaboratorioDescripcion ,
                                           A168LaboratorioNroDocumento ,
                                           Short.valueOf(A170LaboratorioComision) ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV59Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV59Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV59Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV59Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV59Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV59Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV59Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV59Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV59Laboratoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Laboratoriowwds_1_filterfulltext), "%", "") ;
      lV62Laboratoriowwds_4_tflaboratorionombre = GXutil.concat( GXutil.rtrim( AV62Laboratoriowwds_4_tflaboratorionombre), "%", "") ;
      lV64Laboratoriowwds_6_tflaboratoriodescripcion = GXutil.concat( GXutil.rtrim( AV64Laboratoriowwds_6_tflaboratoriodescripcion), "%", "") ;
      lV67Laboratoriowwds_9_tflaboratorionrodocumento = GXutil.concat( GXutil.rtrim( AV67Laboratoriowwds_9_tflaboratorionrodocumento), "%", "") ;
      /* Using cursor P00452 */
      pr_default.execute(0, new Object[] {lV59Laboratoriowwds_1_filterfulltext, lV59Laboratoriowwds_1_filterfulltext, lV59Laboratoriowwds_1_filterfulltext, lV59Laboratoriowwds_1_filterfulltext, lV59Laboratoriowwds_1_filterfulltext, lV59Laboratoriowwds_1_filterfulltext, lV59Laboratoriowwds_1_filterfulltext, lV59Laboratoriowwds_1_filterfulltext, lV59Laboratoriowwds_1_filterfulltext, Short.valueOf(AV60Laboratoriowwds_2_tflaboratorioid), Short.valueOf(AV61Laboratoriowwds_3_tflaboratorioid_to), lV62Laboratoriowwds_4_tflaboratorionombre, AV63Laboratoriowwds_5_tflaboratorionombre_sel, lV64Laboratoriowwds_6_tflaboratoriodescripcion, AV65Laboratoriowwds_7_tflaboratoriodescripcion_sel, lV67Laboratoriowwds_9_tflaboratorionrodocumento, AV68Laboratoriowwds_10_tflaboratorionrodocumento_sel, Short.valueOf(AV69Laboratoriowwds_11_tflaboratoriocomision), Short.valueOf(AV70Laboratoriowwds_12_tflaboratoriocomision_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A170LaboratorioComision = P00452_A170LaboratorioComision[0] ;
         A40LaboratorioId = P00452_A40LaboratorioId[0] ;
         A171LaboratorioEstado = P00452_A171LaboratorioEstado[0] ;
         A168LaboratorioNroDocumento = P00452_A168LaboratorioNroDocumento[0] ;
         A167LaboratorioTipoDocumento = P00452_A167LaboratorioTipoDocumento[0] ;
         A166LaboratorioDescripcion = P00452_A166LaboratorioDescripcion[0] ;
         A165LaboratorioNombre = P00452_A165LaboratorioNombre[0] ;
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
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A40LaboratorioId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A165LaboratorioNombre, GXv_char7) ;
            laboratoriowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A166LaboratorioDescripcion, GXv_char7) ;
            laboratoriowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomaintipodocumentolaboratorio.getDescription(httpContext,(String)A167LaboratorioTipoDocumento) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A168LaboratorioNroDocumento, GXv_char7) ;
            laboratoriowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( "" );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A170LaboratorioComision );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomainestado.getDescription(httpContext,(String)A171LaboratorioEstado) );
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
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LaboratorioId", "", "Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LaboratorioNombre", "", "Nombre", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LaboratorioDescripcion", "", "Descripcion", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LaboratorioTipoDocumento", "", "Tipo Documento", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LaboratorioNroDocumento", "", "Nro Documento", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LaboratorioPhoto", "", "Imagen", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LaboratorioComision", "", "Comision", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LaboratorioEstado", "", "Estado", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV28UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "LaboratorioWWColumnsSelector", GXv_char7) ;
      laboratoriowwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("LaboratorioWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "LaboratorioWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("LaboratorioWWGridState"), null, null);
      }
      AV17OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV18OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV72GXV4 = 1 ;
      while ( AV72GXV4 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV72GXV4));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV19FilterFullText = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIOID") == 0 )
         {
            AV35TFLaboratorioId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFLaboratorioId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIONOMBRE") == 0 )
         {
            AV37TFLaboratorioNombre = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIONOMBRE_SEL") == 0 )
         {
            AV38TFLaboratorioNombre_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIODESCRIPCION") == 0 )
         {
            AV39TFLaboratorioDescripcion = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIODESCRIPCION_SEL") == 0 )
         {
            AV40TFLaboratorioDescripcion_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIOTIPODOCUMENTO_SEL") == 0 )
         {
            AV41TFLaboratorioTipoDocumento_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV42TFLaboratorioTipoDocumento_Sels.fromJSonString(AV41TFLaboratorioTipoDocumento_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIONRODOCUMENTO") == 0 )
         {
            AV44TFLaboratorioNroDocumento = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIONRODOCUMENTO_SEL") == 0 )
         {
            AV45TFLaboratorioNroDocumento_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIOCOMISION") == 0 )
         {
            AV46TFLaboratorioComision = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV47TFLaboratorioComision_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIOESTADO_SEL") == 0 )
         {
            AV48TFLaboratorioEstado_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV49TFLaboratorioEstado_Sels.fromJSonString(AV48TFLaboratorioEstado_SelsJson, null);
         }
         AV72GXV4 = (int)(AV72GXV4+1) ;
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
      this.aP0[0] = laboratoriowwexport.this.AV12Filename;
      this.aP1[0] = laboratoriowwexport.this.AV13ErrorMessage;
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
      AV54Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV19FilterFullText = "" ;
      AV38TFLaboratorioNombre_Sel = "" ;
      AV37TFLaboratorioNombre = "" ;
      AV40TFLaboratorioDescripcion_Sel = "" ;
      AV39TFLaboratorioDescripcion = "" ;
      AV42TFLaboratorioTipoDocumento_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43TFLaboratorioTipoDocumento_Sel = "" ;
      AV45TFLaboratorioNroDocumento_Sel = "" ;
      AV44TFLaboratorioNroDocumento = "" ;
      AV49TFLaboratorioEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV50TFLaboratorioEstado_Sel = "" ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A165LaboratorioNombre = "" ;
      A166LaboratorioDescripcion = "" ;
      A167LaboratorioTipoDocumento = "" ;
      A168LaboratorioNroDocumento = "" ;
      A171LaboratorioEstado = "" ;
      AV59Laboratoriowwds_1_filterfulltext = "" ;
      AV62Laboratoriowwds_4_tflaboratorionombre = "" ;
      AV63Laboratoriowwds_5_tflaboratorionombre_sel = "" ;
      AV64Laboratoriowwds_6_tflaboratoriodescripcion = "" ;
      AV65Laboratoriowwds_7_tflaboratoriodescripcion_sel = "" ;
      AV66Laboratoriowwds_8_tflaboratoriotipodocumento_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV67Laboratoriowwds_9_tflaboratorionrodocumento = "" ;
      AV68Laboratoriowwds_10_tflaboratorionrodocumento_sel = "" ;
      AV71Laboratoriowwds_13_tflaboratorioestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV59Laboratoriowwds_1_filterfulltext = "" ;
      lV62Laboratoriowwds_4_tflaboratorionombre = "" ;
      lV64Laboratoriowwds_6_tflaboratoriodescripcion = "" ;
      lV67Laboratoriowwds_9_tflaboratorionrodocumento = "" ;
      P00452_A170LaboratorioComision = new short[1] ;
      P00452_A40LaboratorioId = new short[1] ;
      P00452_A171LaboratorioEstado = new String[] {""} ;
      P00452_A168LaboratorioNroDocumento = new String[] {""} ;
      P00452_A167LaboratorioTipoDocumento = new String[] {""} ;
      P00452_A166LaboratorioDescripcion = new String[] {""} ;
      P00452_A165LaboratorioNombre = new String[] {""} ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV41TFLaboratorioTipoDocumento_SelsJson = "" ;
      AV48TFLaboratorioEstado_SelsJson = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.laboratoriowwexport__default(),
         new Object[] {
             new Object[] {
            P00452_A170LaboratorioComision, P00452_A40LaboratorioId, P00452_A171LaboratorioEstado, P00452_A168LaboratorioNroDocumento, P00452_A167LaboratorioTipoDocumento, P00452_A166LaboratorioDescripcion, P00452_A165LaboratorioNombre
            }
         }
      );
      AV54Pgmname = "LaboratorioWWExport" ;
      /* GeneXus formulas. */
      AV54Pgmname = "LaboratorioWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV35TFLaboratorioId ;
   private short AV36TFLaboratorioId_To ;
   private short AV46TFLaboratorioComision ;
   private short AV47TFLaboratorioComision_To ;
   private short GXv_int5[] ;
   private short A40LaboratorioId ;
   private short A170LaboratorioComision ;
   private short AV60Laboratoriowwds_2_tflaboratorioid ;
   private short AV61Laboratoriowwds_3_tflaboratorioid_to ;
   private short AV69Laboratoriowwds_11_tflaboratoriocomision ;
   private short AV70Laboratoriowwds_12_tflaboratoriocomision_to ;
   private short AV17OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV55GXV1 ;
   private int AV56GXV2 ;
   private int AV57GXV3 ;
   private int AV66Laboratoriowwds_8_tflaboratoriotipodocumento_sels_size ;
   private int AV71Laboratoriowwds_13_tflaboratorioestado_sels_size ;
   private int AV72GXV4 ;
   private long AV51i ;
   private long AV32VisibleColumnCount ;
   private String AV54Pgmname ;
   private String AV43TFLaboratorioTipoDocumento_Sel ;
   private String AV50TFLaboratorioEstado_Sel ;
   private String A167LaboratorioTipoDocumento ;
   private String A171LaboratorioEstado ;
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
   private String AV41TFLaboratorioTipoDocumento_SelsJson ;
   private String AV48TFLaboratorioEstado_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV19FilterFullText ;
   private String AV38TFLaboratorioNombre_Sel ;
   private String AV37TFLaboratorioNombre ;
   private String AV40TFLaboratorioDescripcion_Sel ;
   private String AV39TFLaboratorioDescripcion ;
   private String AV45TFLaboratorioNroDocumento_Sel ;
   private String AV44TFLaboratorioNroDocumento ;
   private String A165LaboratorioNombre ;
   private String A166LaboratorioDescripcion ;
   private String A168LaboratorioNroDocumento ;
   private String AV59Laboratoriowwds_1_filterfulltext ;
   private String AV62Laboratoriowwds_4_tflaboratorionombre ;
   private String AV63Laboratoriowwds_5_tflaboratorionombre_sel ;
   private String AV64Laboratoriowwds_6_tflaboratoriodescripcion ;
   private String AV65Laboratoriowwds_7_tflaboratoriodescripcion_sel ;
   private String AV67Laboratoriowwds_9_tflaboratorionrodocumento ;
   private String AV68Laboratoriowwds_10_tflaboratorionrodocumento_sel ;
   private String lV59Laboratoriowwds_1_filterfulltext ;
   private String lV62Laboratoriowwds_4_tflaboratorionombre ;
   private String lV64Laboratoriowwds_6_tflaboratoriodescripcion ;
   private String lV67Laboratoriowwds_9_tflaboratorionrodocumento ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV42TFLaboratorioTipoDocumento_Sels ;
   private GXSimpleCollection<String> AV49TFLaboratorioEstado_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P00452_A170LaboratorioComision ;
   private short[] P00452_A40LaboratorioId ;
   private String[] P00452_A171LaboratorioEstado ;
   private String[] P00452_A168LaboratorioNroDocumento ;
   private String[] P00452_A167LaboratorioTipoDocumento ;
   private String[] P00452_A166LaboratorioDescripcion ;
   private String[] P00452_A165LaboratorioNombre ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV66Laboratoriowwds_8_tflaboratoriotipodocumento_sels ;
   private GXSimpleCollection<String> AV71Laboratoriowwds_13_tflaboratorioestado_sels ;
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

final  class laboratoriowwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00452( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A167LaboratorioTipoDocumento ,
                                          GXSimpleCollection<String> AV66Laboratoriowwds_8_tflaboratoriotipodocumento_sels ,
                                          String A171LaboratorioEstado ,
                                          GXSimpleCollection<String> AV71Laboratoriowwds_13_tflaboratorioestado_sels ,
                                          String AV59Laboratoriowwds_1_filterfulltext ,
                                          short AV60Laboratoriowwds_2_tflaboratorioid ,
                                          short AV61Laboratoriowwds_3_tflaboratorioid_to ,
                                          String AV63Laboratoriowwds_5_tflaboratorionombre_sel ,
                                          String AV62Laboratoriowwds_4_tflaboratorionombre ,
                                          String AV65Laboratoriowwds_7_tflaboratoriodescripcion_sel ,
                                          String AV64Laboratoriowwds_6_tflaboratoriodescripcion ,
                                          int AV66Laboratoriowwds_8_tflaboratoriotipodocumento_sels_size ,
                                          String AV68Laboratoriowwds_10_tflaboratorionrodocumento_sel ,
                                          String AV67Laboratoriowwds_9_tflaboratorionrodocumento ,
                                          short AV69Laboratoriowwds_11_tflaboratoriocomision ,
                                          short AV70Laboratoriowwds_12_tflaboratoriocomision_to ,
                                          int AV71Laboratoriowwds_13_tflaboratorioestado_sels_size ,
                                          short A40LaboratorioId ,
                                          String A165LaboratorioNombre ,
                                          String A166LaboratorioDescripcion ,
                                          String A168LaboratorioNroDocumento ,
                                          short A170LaboratorioComision ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[19];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT [LaboratorioComision], [LaboratorioId], [LaboratorioEstado], [LaboratorioNroDocumento], [LaboratorioTipoDocumento], [LaboratorioDescripcion], [LaboratorioNombre]" ;
      scmdbuf += " FROM [Laboratorio]" ;
      if ( ! (GXutil.strcmp("", AV59Laboratoriowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([LaboratorioId] AS decimal(4,0))) like '%' + ?) or ( [LaboratorioNombre] like '%' + ?) or ( [LaboratorioDescripcion] like '%' + ?) or ( 'ruc' like '%' + LOWER(?) and [LaboratorioTipoDocumento] = '6') or ( 'dni' like '%' + LOWER(?) and [LaboratorioTipoDocumento] = '1') or ( [LaboratorioNroDocumento] like '%' + ?) or ( CONVERT( char(4), CAST([LaboratorioComision] AS decimal(4,0))) like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [LaboratorioEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [LaboratorioEstado] = 'I'))");
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
      if ( ! (0==AV60Laboratoriowwds_2_tflaboratorioid) )
      {
         addWhere(sWhereString, "([LaboratorioId] >= ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( ! (0==AV61Laboratoriowwds_3_tflaboratorioid_to) )
      {
         addWhere(sWhereString, "([LaboratorioId] <= ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV63Laboratoriowwds_5_tflaboratorionombre_sel)==0) && ( ! (GXutil.strcmp("", AV62Laboratoriowwds_4_tflaboratorionombre)==0) ) )
      {
         addWhere(sWhereString, "([LaboratorioNombre] like ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV63Laboratoriowwds_5_tflaboratorionombre_sel)==0) )
      {
         addWhere(sWhereString, "([LaboratorioNombre] = ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV65Laboratoriowwds_7_tflaboratoriodescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV64Laboratoriowwds_6_tflaboratoriodescripcion)==0) ) )
      {
         addWhere(sWhereString, "([LaboratorioDescripcion] like ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV65Laboratoriowwds_7_tflaboratoriodescripcion_sel)==0) )
      {
         addWhere(sWhereString, "([LaboratorioDescripcion] = ?)");
      }
      else
      {
         GXv_int10[14] = (byte)(1) ;
      }
      if ( AV66Laboratoriowwds_8_tflaboratoriotipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV66Laboratoriowwds_8_tflaboratoriotipodocumento_sels, "[LaboratorioTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV68Laboratoriowwds_10_tflaboratorionrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV67Laboratoriowwds_9_tflaboratorionrodocumento)==0) ) )
      {
         addWhere(sWhereString, "([LaboratorioNroDocumento] like ?)");
      }
      else
      {
         GXv_int10[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Laboratoriowwds_10_tflaboratorionrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "([LaboratorioNroDocumento] = ?)");
      }
      else
      {
         GXv_int10[16] = (byte)(1) ;
      }
      if ( ! (0==AV69Laboratoriowwds_11_tflaboratoriocomision) )
      {
         addWhere(sWhereString, "([LaboratorioComision] >= ?)");
      }
      else
      {
         GXv_int10[17] = (byte)(1) ;
      }
      if ( ! (0==AV70Laboratoriowwds_12_tflaboratoriocomision_to) )
      {
         addWhere(sWhereString, "([LaboratorioComision] <= ?)");
      }
      else
      {
         GXv_int10[18] = (byte)(1) ;
      }
      if ( AV71Laboratoriowwds_13_tflaboratorioestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV71Laboratoriowwds_13_tflaboratorioestado_sels, "[LaboratorioEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [LaboratorioNombre]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [LaboratorioNombre] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [LaboratorioId]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [LaboratorioId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [LaboratorioDescripcion]" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [LaboratorioDescripcion] DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [LaboratorioTipoDocumento]" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [LaboratorioTipoDocumento] DESC" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [LaboratorioNroDocumento]" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [LaboratorioNroDocumento] DESC" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [LaboratorioComision]" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [LaboratorioComision] DESC" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [LaboratorioEstado]" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [LaboratorioEstado] DESC" ;
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
                  return conditional_P00452(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (String)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).shortValue() , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).shortValue() , ((Boolean) dynConstraints[23]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00452", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
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
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[28]).shortValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[29]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 500);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 500);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 20);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 20);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[36]).shortValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[37]).shortValue());
               }
               return;
      }
   }

}

