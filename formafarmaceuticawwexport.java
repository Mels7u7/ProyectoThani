package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class formafarmaceuticawwexport extends GXProcedure
{
   public formafarmaceuticawwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( formafarmaceuticawwexport.class ), "" );
   }

   public formafarmaceuticawwexport( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      formafarmaceuticawwexport.this.aP1 = new String[] {""};
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
      formafarmaceuticawwexport.this.aP0 = aP0;
      formafarmaceuticawwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWFormaFarmaceutica", GXv_boolean2) ;
      formafarmaceuticawwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
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
      AV12Filename = "FormaFarmaceuticaWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
         formafarmaceuticawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV19FilterFullText, GXv_char7) ;
         formafarmaceuticawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      if ( ! ( (0==AV35TFFormaFarmaceuticaId) && (0==AV36TFFormaFarmaceuticaId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Farmaceutica") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         formafarmaceuticawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFFormaFarmaceuticaId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         formafarmaceuticawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFFormaFarmaceuticaId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV38TFFormaFarmaceuticaCodigo_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Farmaceutica Codigo") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         formafarmaceuticawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFFormaFarmaceuticaCodigo_Sel, GXv_char7) ;
         formafarmaceuticawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV37TFFormaFarmaceuticaCodigo)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Farmaceutica Codigo") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            formafarmaceuticawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV37TFFormaFarmaceuticaCodigo, GXv_char7) ;
            formafarmaceuticawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV40TFFormaFarmaceuticaDescripcion_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Farmaceutica Descripcion") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         formafarmaceuticawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFFormaFarmaceuticaDescripcion_Sel, GXv_char7) ;
         formafarmaceuticawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV39TFFormaFarmaceuticaDescripcion)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Farmaceutica Descripcion") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            formafarmaceuticawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV39TFFormaFarmaceuticaDescripcion, GXv_char7) ;
            formafarmaceuticawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV42TFFormaFarmaceuticaEstado_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Farmaceutica Estado") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         formafarmaceuticawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV46i = 1 ;
         AV50GXV1 = 1 ;
         while ( AV50GXV1 <= AV42TFFormaFarmaceuticaEstado_Sels.size() )
         {
            AV43TFFormaFarmaceuticaEstado_Sel = (String)AV42TFFormaFarmaceuticaEstado_Sels.elementAt(-1+AV50GXV1) ;
            if ( AV46i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomainestado.getDescription(httpContext,(String)AV43TFFormaFarmaceuticaEstado_Sel) );
            AV46i = (long)(AV46i+1) ;
            AV50GXV1 = (int)(AV50GXV1+1) ;
         }
      }
      if ( ! ( (GXutil.strcmp("", AV45TFFormaFarmaceuticaDescripcion2_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Farmaceutica Descripcion2") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         formafarmaceuticawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV45TFFormaFarmaceuticaDescripcion2_Sel, GXv_char7) ;
         formafarmaceuticawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV44TFFormaFarmaceuticaDescripcion2)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Farmaceutica Descripcion2") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            formafarmaceuticawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV44TFFormaFarmaceuticaDescripcion2, GXv_char7) ;
            formafarmaceuticawwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("FormaFarmaceuticaWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("FormaFarmaceuticaWWColumnsSelector") ;
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
      AV53Formafarmaceuticawwds_1_filterfulltext = AV19FilterFullText ;
      AV54Formafarmaceuticawwds_2_tfformafarmaceuticaid = AV35TFFormaFarmaceuticaId ;
      AV55Formafarmaceuticawwds_3_tfformafarmaceuticaid_to = AV36TFFormaFarmaceuticaId_To ;
      AV56Formafarmaceuticawwds_4_tfformafarmaceuticacodigo = AV37TFFormaFarmaceuticaCodigo ;
      AV57Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel = AV38TFFormaFarmaceuticaCodigo_Sel ;
      AV58Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion = AV39TFFormaFarmaceuticaDescripcion ;
      AV59Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel = AV40TFFormaFarmaceuticaDescripcion_Sel ;
      AV60Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels = AV42TFFormaFarmaceuticaEstado_Sels ;
      AV61Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 = AV44TFFormaFarmaceuticaDescripcion2 ;
      AV62Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel = AV45TFFormaFarmaceuticaDescripcion2_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A163FormaFarmaceuticaEstado ,
                                           AV60Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels ,
                                           AV53Formafarmaceuticawwds_1_filterfulltext ,
                                           Short.valueOf(AV54Formafarmaceuticawwds_2_tfformafarmaceuticaid) ,
                                           Short.valueOf(AV55Formafarmaceuticawwds_3_tfformafarmaceuticaid_to) ,
                                           AV57Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel ,
                                           AV56Formafarmaceuticawwds_4_tfformafarmaceuticacodigo ,
                                           AV59Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel ,
                                           AV58Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion ,
                                           Integer.valueOf(AV60Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels.size()) ,
                                           AV62Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel ,
                                           AV61Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 ,
                                           Short.valueOf(A39FormaFarmaceuticaId) ,
                                           A161FormaFarmaceuticaCodigo ,
                                           A162FormaFarmaceuticaDescripcion ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV53Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV53Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV53Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV53Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV53Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV53Formafarmaceuticawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV53Formafarmaceuticawwds_1_filterfulltext), "%", "") ;
      lV56Formafarmaceuticawwds_4_tfformafarmaceuticacodigo = GXutil.concat( GXutil.rtrim( AV56Formafarmaceuticawwds_4_tfformafarmaceuticacodigo), "%", "") ;
      lV58Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion = GXutil.concat( GXutil.rtrim( AV58Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion), "%", "") ;
      lV61Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 = GXutil.concat( GXutil.rtrim( AV61Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2), "%", "") ;
      /* Using cursor P007W2 */
      pr_default.execute(0, new Object[] {lV53Formafarmaceuticawwds_1_filterfulltext, lV53Formafarmaceuticawwds_1_filterfulltext, lV53Formafarmaceuticawwds_1_filterfulltext, lV53Formafarmaceuticawwds_1_filterfulltext, lV53Formafarmaceuticawwds_1_filterfulltext, lV53Formafarmaceuticawwds_1_filterfulltext, Short.valueOf(AV54Formafarmaceuticawwds_2_tfformafarmaceuticaid), Short.valueOf(AV55Formafarmaceuticawwds_3_tfformafarmaceuticaid_to), lV56Formafarmaceuticawwds_4_tfformafarmaceuticacodigo, AV57Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel, lV58Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion, AV59Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel, lV61Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2, AV62Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A39FormaFarmaceuticaId = P007W2_A39FormaFarmaceuticaId[0] ;
         A163FormaFarmaceuticaEstado = P007W2_A163FormaFarmaceuticaEstado[0] ;
         A162FormaFarmaceuticaDescripcion = P007W2_A162FormaFarmaceuticaDescripcion[0] ;
         A161FormaFarmaceuticaCodigo = P007W2_A161FormaFarmaceuticaCodigo[0] ;
         A164FormaFarmaceuticaDescripcion2 = A161FormaFarmaceuticaCodigo + " - " + A162FormaFarmaceuticaDescripcion ;
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
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A39FormaFarmaceuticaId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A161FormaFarmaceuticaCodigo, GXv_char7) ;
            formafarmaceuticawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A162FormaFarmaceuticaDescripcion, GXv_char7) ;
            formafarmaceuticawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomainestado.getDescription(httpContext,(String)A163FormaFarmaceuticaEstado) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A164FormaFarmaceuticaDescripcion2, GXv_char7) ;
            formafarmaceuticawwexport.this.GXt_char6 = GXv_char7[0] ;
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
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "FormaFarmaceuticaId", "", "Farmaceutica", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "FormaFarmaceuticaCodigo", "", "Farmaceutica Codigo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "FormaFarmaceuticaDescripcion", "", "Farmaceutica Descripcion", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "FormaFarmaceuticaEstado", "", "Farmaceutica Estado", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "FormaFarmaceuticaDescripcion2", "", "Farmaceutica Descripcion2", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV28UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "FormaFarmaceuticaWWColumnsSelector", GXv_char7) ;
      formafarmaceuticawwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("FormaFarmaceuticaWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "FormaFarmaceuticaWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("FormaFarmaceuticaWWGridState"), null, null);
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
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFORMAFARMACEUTICAID") == 0 )
         {
            AV35TFFormaFarmaceuticaId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFFormaFarmaceuticaId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFORMAFARMACEUTICACODIGO") == 0 )
         {
            AV37TFFormaFarmaceuticaCodigo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFORMAFARMACEUTICACODIGO_SEL") == 0 )
         {
            AV38TFFormaFarmaceuticaCodigo_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFORMAFARMACEUTICADESCRIPCION") == 0 )
         {
            AV39TFFormaFarmaceuticaDescripcion = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFORMAFARMACEUTICADESCRIPCION_SEL") == 0 )
         {
            AV40TFFormaFarmaceuticaDescripcion_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFORMAFARMACEUTICAESTADO_SEL") == 0 )
         {
            AV41TFFormaFarmaceuticaEstado_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV42TFFormaFarmaceuticaEstado_Sels.fromJSonString(AV41TFFormaFarmaceuticaEstado_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFORMAFARMACEUTICADESCRIPCION2") == 0 )
         {
            AV44TFFormaFarmaceuticaDescripcion2 = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFORMAFARMACEUTICADESCRIPCION2_SEL") == 0 )
         {
            AV45TFFormaFarmaceuticaDescripcion2_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
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
      this.aP0[0] = formafarmaceuticawwexport.this.AV12Filename;
      this.aP1[0] = formafarmaceuticawwexport.this.AV13ErrorMessage;
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
      AV38TFFormaFarmaceuticaCodigo_Sel = "" ;
      AV37TFFormaFarmaceuticaCodigo = "" ;
      AV40TFFormaFarmaceuticaDescripcion_Sel = "" ;
      AV39TFFormaFarmaceuticaDescripcion = "" ;
      AV42TFFormaFarmaceuticaEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43TFFormaFarmaceuticaEstado_Sel = "" ;
      AV45TFFormaFarmaceuticaDescripcion2_Sel = "" ;
      AV44TFFormaFarmaceuticaDescripcion2 = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A161FormaFarmaceuticaCodigo = "" ;
      A162FormaFarmaceuticaDescripcion = "" ;
      A163FormaFarmaceuticaEstado = "" ;
      A164FormaFarmaceuticaDescripcion2 = "" ;
      AV53Formafarmaceuticawwds_1_filterfulltext = "" ;
      AV56Formafarmaceuticawwds_4_tfformafarmaceuticacodigo = "" ;
      AV57Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel = "" ;
      AV58Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion = "" ;
      AV59Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel = "" ;
      AV60Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV61Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 = "" ;
      AV62Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel = "" ;
      scmdbuf = "" ;
      lV53Formafarmaceuticawwds_1_filterfulltext = "" ;
      lV56Formafarmaceuticawwds_4_tfformafarmaceuticacodigo = "" ;
      lV58Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion = "" ;
      lV61Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 = "" ;
      P007W2_A39FormaFarmaceuticaId = new short[1] ;
      P007W2_A163FormaFarmaceuticaEstado = new String[] {""} ;
      P007W2_A162FormaFarmaceuticaDescripcion = new String[] {""} ;
      P007W2_A161FormaFarmaceuticaCodigo = new String[] {""} ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV41TFFormaFarmaceuticaEstado_SelsJson = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.formafarmaceuticawwexport__default(),
         new Object[] {
             new Object[] {
            P007W2_A39FormaFarmaceuticaId, P007W2_A163FormaFarmaceuticaEstado, P007W2_A162FormaFarmaceuticaDescripcion, P007W2_A161FormaFarmaceuticaCodigo
            }
         }
      );
      AV49Pgmname = "FormaFarmaceuticaWWExport" ;
      /* GeneXus formulas. */
      AV49Pgmname = "FormaFarmaceuticaWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV35TFFormaFarmaceuticaId ;
   private short AV36TFFormaFarmaceuticaId_To ;
   private short GXv_int5[] ;
   private short A39FormaFarmaceuticaId ;
   private short AV54Formafarmaceuticawwds_2_tfformafarmaceuticaid ;
   private short AV55Formafarmaceuticawwds_3_tfformafarmaceuticaid_to ;
   private short AV17OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV50GXV1 ;
   private int AV51GXV2 ;
   private int AV60Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels_size ;
   private int AV63GXV3 ;
   private long AV46i ;
   private long AV32VisibleColumnCount ;
   private String AV49Pgmname ;
   private String AV43TFFormaFarmaceuticaEstado_Sel ;
   private String A163FormaFarmaceuticaEstado ;
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
   private String AV41TFFormaFarmaceuticaEstado_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV19FilterFullText ;
   private String AV38TFFormaFarmaceuticaCodigo_Sel ;
   private String AV37TFFormaFarmaceuticaCodigo ;
   private String AV40TFFormaFarmaceuticaDescripcion_Sel ;
   private String AV39TFFormaFarmaceuticaDescripcion ;
   private String AV45TFFormaFarmaceuticaDescripcion2_Sel ;
   private String AV44TFFormaFarmaceuticaDescripcion2 ;
   private String A161FormaFarmaceuticaCodigo ;
   private String A162FormaFarmaceuticaDescripcion ;
   private String A164FormaFarmaceuticaDescripcion2 ;
   private String AV53Formafarmaceuticawwds_1_filterfulltext ;
   private String AV56Formafarmaceuticawwds_4_tfformafarmaceuticacodigo ;
   private String AV57Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel ;
   private String AV58Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion ;
   private String AV59Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel ;
   private String AV61Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 ;
   private String AV62Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel ;
   private String lV53Formafarmaceuticawwds_1_filterfulltext ;
   private String lV56Formafarmaceuticawwds_4_tfformafarmaceuticacodigo ;
   private String lV58Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion ;
   private String lV61Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV42TFFormaFarmaceuticaEstado_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P007W2_A39FormaFarmaceuticaId ;
   private String[] P007W2_A163FormaFarmaceuticaEstado ;
   private String[] P007W2_A162FormaFarmaceuticaDescripcion ;
   private String[] P007W2_A161FormaFarmaceuticaCodigo ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV60Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels ;
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

final  class formafarmaceuticawwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P007W2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A163FormaFarmaceuticaEstado ,
                                          GXSimpleCollection<String> AV60Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels ,
                                          String AV53Formafarmaceuticawwds_1_filterfulltext ,
                                          short AV54Formafarmaceuticawwds_2_tfformafarmaceuticaid ,
                                          short AV55Formafarmaceuticawwds_3_tfformafarmaceuticaid_to ,
                                          String AV57Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel ,
                                          String AV56Formafarmaceuticawwds_4_tfformafarmaceuticacodigo ,
                                          String AV59Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel ,
                                          String AV58Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion ,
                                          int AV60Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels_size ,
                                          String AV62Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel ,
                                          String AV61Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2 ,
                                          short A39FormaFarmaceuticaId ,
                                          String A161FormaFarmaceuticaCodigo ,
                                          String A162FormaFarmaceuticaDescripcion ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[14];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT [FormaFarmaceuticaId], [FormaFarmaceuticaEstado], [FormaFarmaceuticaDescripcion], [FormaFarmaceuticaCodigo] FROM [FormaFarmaceutica]" ;
      if ( ! (GXutil.strcmp("", AV53Formafarmaceuticawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([FormaFarmaceuticaId] AS decimal(4,0))) like '%' + ?) or ( [FormaFarmaceuticaCodigo] like '%' + ?) or ( [FormaFarmaceuticaDescripcion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [FormaFarmaceuticaEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [FormaFarmaceuticaEstado] = 'I') or ( [FormaFarmaceuticaCodigo] + ' - ' + [FormaFarmaceuticaDescripcion] like '%' + ?))");
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
      if ( ! (0==AV54Formafarmaceuticawwds_2_tfformafarmaceuticaid) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaId] >= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( ! (0==AV55Formafarmaceuticawwds_3_tfformafarmaceuticaid_to) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaId] <= ?)");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV57Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel)==0) && ( ! (GXutil.strcmp("", AV56Formafarmaceuticawwds_4_tfformafarmaceuticacodigo)==0) ) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaCodigo] like ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV57Formafarmaceuticawwds_5_tfformafarmaceuticacodigo_sel)==0) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaCodigo] = ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV59Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV58Formafarmaceuticawwds_6_tfformafarmaceuticadescripcion)==0) ) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaDescripcion] like ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV59Formafarmaceuticawwds_7_tfformafarmaceuticadescripcion_sel)==0) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaDescripcion] = ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( AV60Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV60Formafarmaceuticawwds_8_tfformafarmaceuticaestado_sels, "[FormaFarmaceuticaEstado] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV62Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel)==0) && ( ! (GXutil.strcmp("", AV61Formafarmaceuticawwds_9_tfformafarmaceuticadescripcion2)==0) ) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaCodigo] + ' - ' + [FormaFarmaceuticaDescripcion] like ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV62Formafarmaceuticawwds_10_tfformafarmaceuticadescripcion2_sel)==0) )
      {
         addWhere(sWhereString, "([FormaFarmaceuticaCodigo] + ' - ' + [FormaFarmaceuticaDescripcion] = ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [FormaFarmaceuticaId]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [FormaFarmaceuticaId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [FormaFarmaceuticaCodigo]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [FormaFarmaceuticaCodigo] DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [FormaFarmaceuticaDescripcion]" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [FormaFarmaceuticaDescripcion] DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [FormaFarmaceuticaEstado]" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [FormaFarmaceuticaEstado] DESC" ;
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
                  return conditional_P007W2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Boolean) dynConstraints[16]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P007W2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
                  stmt.setVarchar(sIdx, (String)parms[24], 1000);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 1000);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 40);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 40);
               }
               return;
      }
   }

}

