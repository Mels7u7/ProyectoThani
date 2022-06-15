package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class especialidadwwexport extends GXProcedure
{
   public especialidadwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( especialidadwwexport.class ), "" );
   }

   public especialidadwwexport( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      especialidadwwexport.this.aP1 = new String[] {""};
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
      especialidadwwexport.this.aP0 = aP0;
      especialidadwwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEspecialidad", GXv_boolean2) ;
      especialidadwwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV49Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "EspecialidadWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
         especialidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV19FilterFullText, GXv_char7) ;
         especialidadwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      if ( ! ( (0==AV35TFEspecialidadId) && (0==AV36TFEspecialidadId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         especialidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFEspecialidadId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         especialidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFEspecialidadId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV38TFEspecialidadNombre_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nombre") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         especialidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFEspecialidadNombre_Sel, GXv_char7) ;
         especialidadwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV37TFEspecialidadNombre)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nombre") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            especialidadwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV37TFEspecialidadNombre, GXv_char7) ;
            especialidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV40TFEspecialidadDescripcion_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Descripcion") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         especialidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFEspecialidadDescripcion_Sel, GXv_char7) ;
         especialidadwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV39TFEspecialidadDescripcion)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Descripcion") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            especialidadwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV39TFEspecialidadDescripcion, GXv_char7) ;
            especialidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV42TFEspecialidadCodigo_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Codigo") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         especialidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFEspecialidadCodigo_Sel, GXv_char7) ;
         especialidadwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV41TFEspecialidadCodigo)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Codigo") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            especialidadwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV41TFEspecialidadCodigo, GXv_char7) ;
            especialidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV44TFEspecialidadEstado_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Estado") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         especialidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV46i = 1 ;
         AV50GXV1 = 1 ;
         while ( AV50GXV1 <= AV44TFEspecialidadEstado_Sels.size() )
         {
            AV45TFEspecialidadEstado_Sel = (String)AV44TFEspecialidadEstado_Sels.elementAt(-1+AV50GXV1) ;
            if ( AV46i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomainestado.getDescription(httpContext,(String)AV45TFEspecialidadEstado_Sel) );
            AV46i = (long)(AV46i+1) ;
            AV50GXV1 = (int)(AV50GXV1+1) ;
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("EspecialidadWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("EspecialidadWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV51GXV2 = 1 ;
      while ( AV51GXV2 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV51GXV2));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV51GXV2 = (int)(AV51GXV2+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV53Especialidadwwds_1_filterfulltext = AV19FilterFullText ;
      AV54Especialidadwwds_2_tfespecialidadid = AV35TFEspecialidadId ;
      AV55Especialidadwwds_3_tfespecialidadid_to = AV36TFEspecialidadId_To ;
      AV56Especialidadwwds_4_tfespecialidadnombre = AV37TFEspecialidadNombre ;
      AV57Especialidadwwds_5_tfespecialidadnombre_sel = AV38TFEspecialidadNombre_Sel ;
      AV58Especialidadwwds_6_tfespecialidaddescripcion = AV39TFEspecialidadDescripcion ;
      AV59Especialidadwwds_7_tfespecialidaddescripcion_sel = AV40TFEspecialidadDescripcion_Sel ;
      AV60Especialidadwwds_8_tfespecialidadcodigo = AV41TFEspecialidadCodigo ;
      AV61Especialidadwwds_9_tfespecialidadcodigo_sel = AV42TFEspecialidadCodigo_Sel ;
      AV62Especialidadwwds_10_tfespecialidadestado_sels = AV44TFEspecialidadEstado_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A156EspecialidadEstado ,
                                           AV62Especialidadwwds_10_tfespecialidadestado_sels ,
                                           AV53Especialidadwwds_1_filterfulltext ,
                                           Short.valueOf(AV54Especialidadwwds_2_tfespecialidadid) ,
                                           Short.valueOf(AV55Especialidadwwds_3_tfespecialidadid_to) ,
                                           AV57Especialidadwwds_5_tfespecialidadnombre_sel ,
                                           AV56Especialidadwwds_4_tfespecialidadnombre ,
                                           AV59Especialidadwwds_7_tfespecialidaddescripcion_sel ,
                                           AV58Especialidadwwds_6_tfespecialidaddescripcion ,
                                           AV61Especialidadwwds_9_tfespecialidadcodigo_sel ,
                                           AV60Especialidadwwds_8_tfespecialidadcodigo ,
                                           Integer.valueOf(AV62Especialidadwwds_10_tfespecialidadestado_sels.size()) ,
                                           Short.valueOf(A32EspecialidadId) ,
                                           A71EspecialidadNombre ,
                                           A154EspecialidadDescripcion ,
                                           A140EspecialidadCodigo ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV53Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Especialidadwwds_1_filterfulltext), "%", "") ;
      lV53Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Especialidadwwds_1_filterfulltext), "%", "") ;
      lV53Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Especialidadwwds_1_filterfulltext), "%", "") ;
      lV53Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Especialidadwwds_1_filterfulltext), "%", "") ;
      lV53Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Especialidadwwds_1_filterfulltext), "%", "") ;
      lV53Especialidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Especialidadwwds_1_filterfulltext), "%", "") ;
      lV56Especialidadwwds_4_tfespecialidadnombre = GXutil.concat( GXutil.rtrim( AV56Especialidadwwds_4_tfespecialidadnombre), "%", "") ;
      lV58Especialidadwwds_6_tfespecialidaddescripcion = GXutil.concat( GXutil.rtrim( AV58Especialidadwwds_6_tfespecialidaddescripcion), "%", "") ;
      lV60Especialidadwwds_8_tfespecialidadcodigo = GXutil.concat( GXutil.rtrim( AV60Especialidadwwds_8_tfespecialidadcodigo), "%", "") ;
      /* Using cursor P004P2 */
      pr_default.execute(0, new Object[] {lV53Especialidadwwds_1_filterfulltext, lV53Especialidadwwds_1_filterfulltext, lV53Especialidadwwds_1_filterfulltext, lV53Especialidadwwds_1_filterfulltext, lV53Especialidadwwds_1_filterfulltext, lV53Especialidadwwds_1_filterfulltext, Short.valueOf(AV54Especialidadwwds_2_tfespecialidadid), Short.valueOf(AV55Especialidadwwds_3_tfespecialidadid_to), lV56Especialidadwwds_4_tfespecialidadnombre, AV57Especialidadwwds_5_tfespecialidadnombre_sel, lV58Especialidadwwds_6_tfespecialidaddescripcion, AV59Especialidadwwds_7_tfespecialidaddescripcion_sel, lV60Especialidadwwds_8_tfespecialidadcodigo, AV61Especialidadwwds_9_tfespecialidadcodigo_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A32EspecialidadId = P004P2_A32EspecialidadId[0] ;
         A156EspecialidadEstado = P004P2_A156EspecialidadEstado[0] ;
         A140EspecialidadCodigo = P004P2_A140EspecialidadCodigo[0] ;
         A154EspecialidadDescripcion = P004P2_A154EspecialidadDescripcion[0] ;
         A71EspecialidadNombre = P004P2_A71EspecialidadNombre[0] ;
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
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A32EspecialidadId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A71EspecialidadNombre, GXv_char7) ;
            especialidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A154EspecialidadDescripcion, GXv_char7) ;
            especialidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A140EspecialidadCodigo, GXv_char7) ;
            especialidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( "" );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomainestado.getDescription(httpContext,(String)A156EspecialidadEstado) );
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
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EspecialidadId", "", "Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EspecialidadNombre", "", "Nombre", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EspecialidadDescripcion", "", "Descripcion", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EspecialidadCodigo", "", "Codigo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EspecialidadFoto", "", "Foto", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EspecialidadEstado", "", "Estado", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV28UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "EspecialidadWWColumnsSelector", GXv_char7) ;
      especialidadwwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("EspecialidadWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "EspecialidadWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("EspecialidadWWGridState"), null, null);
      }
      AV17OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV18OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV63GXV3 = 1 ;
      while ( AV63GXV3 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV63GXV3));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV19FilterFullText = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADID") == 0 )
         {
            AV35TFEspecialidadId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFEspecialidadId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADNOMBRE") == 0 )
         {
            AV37TFEspecialidadNombre = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADNOMBRE_SEL") == 0 )
         {
            AV38TFEspecialidadNombre_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADDESCRIPCION") == 0 )
         {
            AV39TFEspecialidadDescripcion = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADDESCRIPCION_SEL") == 0 )
         {
            AV40TFEspecialidadDescripcion_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADCODIGO") == 0 )
         {
            AV41TFEspecialidadCodigo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADCODIGO_SEL") == 0 )
         {
            AV42TFEspecialidadCodigo_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADESTADO_SEL") == 0 )
         {
            AV43TFEspecialidadEstado_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV44TFEspecialidadEstado_Sels.fromJSonString(AV43TFEspecialidadEstado_SelsJson, null);
         }
         AV63GXV3 = (int)(AV63GXV3+1) ;
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
      this.aP0[0] = especialidadwwexport.this.AV12Filename;
      this.aP1[0] = especialidadwwexport.this.AV13ErrorMessage;
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
      AV49Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV19FilterFullText = "" ;
      AV38TFEspecialidadNombre_Sel = "" ;
      AV37TFEspecialidadNombre = "" ;
      AV40TFEspecialidadDescripcion_Sel = "" ;
      AV39TFEspecialidadDescripcion = "" ;
      AV42TFEspecialidadCodigo_Sel = "" ;
      AV41TFEspecialidadCodigo = "" ;
      AV44TFEspecialidadEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV45TFEspecialidadEstado_Sel = "" ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A71EspecialidadNombre = "" ;
      A154EspecialidadDescripcion = "" ;
      A140EspecialidadCodigo = "" ;
      A156EspecialidadEstado = "" ;
      AV53Especialidadwwds_1_filterfulltext = "" ;
      AV56Especialidadwwds_4_tfespecialidadnombre = "" ;
      AV57Especialidadwwds_5_tfespecialidadnombre_sel = "" ;
      AV58Especialidadwwds_6_tfespecialidaddescripcion = "" ;
      AV59Especialidadwwds_7_tfespecialidaddescripcion_sel = "" ;
      AV60Especialidadwwds_8_tfespecialidadcodigo = "" ;
      AV61Especialidadwwds_9_tfespecialidadcodigo_sel = "" ;
      AV62Especialidadwwds_10_tfespecialidadestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV53Especialidadwwds_1_filterfulltext = "" ;
      lV56Especialidadwwds_4_tfespecialidadnombre = "" ;
      lV58Especialidadwwds_6_tfespecialidaddescripcion = "" ;
      lV60Especialidadwwds_8_tfespecialidadcodigo = "" ;
      P004P2_A32EspecialidadId = new short[1] ;
      P004P2_A156EspecialidadEstado = new String[] {""} ;
      P004P2_A140EspecialidadCodigo = new String[] {""} ;
      P004P2_A154EspecialidadDescripcion = new String[] {""} ;
      P004P2_A71EspecialidadNombre = new String[] {""} ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV43TFEspecialidadEstado_SelsJson = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.especialidadwwexport__default(),
         new Object[] {
             new Object[] {
            P004P2_A32EspecialidadId, P004P2_A156EspecialidadEstado, P004P2_A140EspecialidadCodigo, P004P2_A154EspecialidadDescripcion, P004P2_A71EspecialidadNombre
            }
         }
      );
      AV49Pgmname = "EspecialidadWWExport" ;
      /* GeneXus formulas. */
      AV49Pgmname = "EspecialidadWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV35TFEspecialidadId ;
   private short AV36TFEspecialidadId_To ;
   private short GXv_int5[] ;
   private short A32EspecialidadId ;
   private short AV54Especialidadwwds_2_tfespecialidadid ;
   private short AV55Especialidadwwds_3_tfespecialidadid_to ;
   private short AV17OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV50GXV1 ;
   private int AV51GXV2 ;
   private int AV62Especialidadwwds_10_tfespecialidadestado_sels_size ;
   private int AV63GXV3 ;
   private long AV46i ;
   private long AV32VisibleColumnCount ;
   private String AV49Pgmname ;
   private String AV45TFEspecialidadEstado_Sel ;
   private String A156EspecialidadEstado ;
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
   private String AV43TFEspecialidadEstado_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV19FilterFullText ;
   private String AV38TFEspecialidadNombre_Sel ;
   private String AV37TFEspecialidadNombre ;
   private String AV40TFEspecialidadDescripcion_Sel ;
   private String AV39TFEspecialidadDescripcion ;
   private String AV42TFEspecialidadCodigo_Sel ;
   private String AV41TFEspecialidadCodigo ;
   private String A71EspecialidadNombre ;
   private String A154EspecialidadDescripcion ;
   private String A140EspecialidadCodigo ;
   private String AV53Especialidadwwds_1_filterfulltext ;
   private String AV56Especialidadwwds_4_tfespecialidadnombre ;
   private String AV57Especialidadwwds_5_tfespecialidadnombre_sel ;
   private String AV58Especialidadwwds_6_tfespecialidaddescripcion ;
   private String AV59Especialidadwwds_7_tfespecialidaddescripcion_sel ;
   private String AV60Especialidadwwds_8_tfespecialidadcodigo ;
   private String AV61Especialidadwwds_9_tfespecialidadcodigo_sel ;
   private String lV53Especialidadwwds_1_filterfulltext ;
   private String lV56Especialidadwwds_4_tfespecialidadnombre ;
   private String lV58Especialidadwwds_6_tfespecialidaddescripcion ;
   private String lV60Especialidadwwds_8_tfespecialidadcodigo ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV44TFEspecialidadEstado_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P004P2_A32EspecialidadId ;
   private String[] P004P2_A156EspecialidadEstado ;
   private String[] P004P2_A140EspecialidadCodigo ;
   private String[] P004P2_A154EspecialidadDescripcion ;
   private String[] P004P2_A71EspecialidadNombre ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV62Especialidadwwds_10_tfespecialidadestado_sels ;
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

final  class especialidadwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P004P2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A156EspecialidadEstado ,
                                          GXSimpleCollection<String> AV62Especialidadwwds_10_tfespecialidadestado_sels ,
                                          String AV53Especialidadwwds_1_filterfulltext ,
                                          short AV54Especialidadwwds_2_tfespecialidadid ,
                                          short AV55Especialidadwwds_3_tfespecialidadid_to ,
                                          String AV57Especialidadwwds_5_tfespecialidadnombre_sel ,
                                          String AV56Especialidadwwds_4_tfespecialidadnombre ,
                                          String AV59Especialidadwwds_7_tfespecialidaddescripcion_sel ,
                                          String AV58Especialidadwwds_6_tfespecialidaddescripcion ,
                                          String AV61Especialidadwwds_9_tfespecialidadcodigo_sel ,
                                          String AV60Especialidadwwds_8_tfespecialidadcodigo ,
                                          int AV62Especialidadwwds_10_tfespecialidadestado_sels_size ,
                                          short A32EspecialidadId ,
                                          String A71EspecialidadNombre ,
                                          String A154EspecialidadDescripcion ,
                                          String A140EspecialidadCodigo ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[14];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT [EspecialidadId], [EspecialidadEstado], [EspecialidadCodigo], [EspecialidadDescripcion], [EspecialidadNombre] FROM [Especialidad]" ;
      if ( ! (GXutil.strcmp("", AV53Especialidadwwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( [EspecialidadNombre] like '%' + ?) or ( [EspecialidadDescripcion] like '%' + ?) or ( [EspecialidadCodigo] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [EspecialidadEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [EspecialidadEstado] = 'I'))");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
         GXv_int10[1] = (byte)(1) ;
         GXv_int10[2] = (byte)(1) ;
         GXv_int10[3] = (byte)(1) ;
         GXv_int10[4] = (byte)(1) ;
         GXv_int10[5] = (byte)(1) ;
      }
      if ( ! (0==AV54Especialidadwwds_2_tfespecialidadid) )
      {
         addWhere(sWhereString, "([EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( ! (0==AV55Especialidadwwds_3_tfespecialidadid_to) )
      {
         addWhere(sWhereString, "([EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV57Especialidadwwds_5_tfespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV56Especialidadwwds_4_tfespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "([EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV57Especialidadwwds_5_tfespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "([EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV59Especialidadwwds_7_tfespecialidaddescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV58Especialidadwwds_6_tfespecialidaddescripcion)==0) ) )
      {
         addWhere(sWhereString, "([EspecialidadDescripcion] like ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV59Especialidadwwds_7_tfespecialidaddescripcion_sel)==0) )
      {
         addWhere(sWhereString, "([EspecialidadDescripcion] = ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV61Especialidadwwds_9_tfespecialidadcodigo_sel)==0) && ( ! (GXutil.strcmp("", AV60Especialidadwwds_8_tfespecialidadcodigo)==0) ) )
      {
         addWhere(sWhereString, "([EspecialidadCodigo] like ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV61Especialidadwwds_9_tfespecialidadcodigo_sel)==0) )
      {
         addWhere(sWhereString, "([EspecialidadCodigo] = ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( AV62Especialidadwwds_10_tfespecialidadestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV62Especialidadwwds_10_tfespecialidadestado_sels, "[EspecialidadEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [EspecialidadNombre]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [EspecialidadNombre] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [EspecialidadId]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [EspecialidadId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [EspecialidadDescripcion]" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [EspecialidadDescripcion] DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [EspecialidadCodigo]" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [EspecialidadCodigo] DESC" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [EspecialidadEstado]" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [EspecialidadEstado] DESC" ;
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
                  return conditional_P004P2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , ((Boolean) dynConstraints[17]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004P2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
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
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[20]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[21]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 40);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 40);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 200);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 200);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 4);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 4);
               }
               return;
      }
   }

}

