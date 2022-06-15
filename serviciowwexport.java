package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class serviciowwexport extends GXProcedure
{
   public serviciowwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( serviciowwexport.class ), "" );
   }

   public serviciowwexport( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      serviciowwexport.this.aP1 = new String[] {""};
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
      serviciowwexport.this.aP0 = aP0;
      serviciowwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWServicio", GXv_boolean2) ;
      serviciowwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV59Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "ServicioWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
         serviciowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV19FilterFullText, GXv_char7) ;
         serviciowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      if ( ! ( (0==AV35TFServicioId) && (0==AV36TFServicioId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         serviciowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFServicioId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         serviciowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFServicioId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV38TFServicioNombre_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nombre") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         serviciowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFServicioNombre_Sel, GXv_char7) ;
         serviciowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV37TFServicioNombre)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nombre") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            serviciowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV37TFServicioNombre, GXv_char7) ;
            serviciowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV40TFServicioDescripcion_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Descripcion") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         serviciowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFServicioDescripcion_Sel, GXv_char7) ;
         serviciowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV39TFServicioDescripcion)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Descripcion") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            serviciowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV39TFServicioDescripcion, GXv_char7) ;
            serviciowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV41TFServicioCosto)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV42TFServicioCosto_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Costo") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         serviciowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV41TFServicioCosto)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         serviciowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV42TFServicioCosto_To)) );
      }
      if ( ! ( (0==AV43TFServicioCategId) && (0==AV44TFServicioCategId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Servicio Categ Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         serviciowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV43TFServicioCategId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         serviciowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV44TFServicioCategId_To );
      }
      if ( ! ( (0==AV45TFLaboratorioId) && (0==AV46TFLaboratorioId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Laboratorio Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         serviciowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV45TFLaboratorioId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         serviciowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV46TFLaboratorioId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV48TFLaboratorioNombre_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Laboratorio Nombre") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         serviciowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV48TFLaboratorioNombre_Sel, GXv_char7) ;
         serviciowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV47TFLaboratorioNombre)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Laboratorio Nombre") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            serviciowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV47TFLaboratorioNombre, GXv_char7) ;
            serviciowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV49TFServicioComision) && (0==AV50TFServicioComision_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Comision") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         serviciowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV49TFServicioComision );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         serviciowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV50TFServicioComision_To );
      }
      if ( ! ( (GXutil.strcmp("", AV52TFServicioObservacion_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Observacion") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         serviciowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV52TFServicioObservacion_Sel, GXv_char7) ;
         serviciowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV51TFServicioObservacion)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Observacion") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            serviciowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV51TFServicioObservacion, GXv_char7) ;
            serviciowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV54TFServicioEstado_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Estado") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         serviciowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV56i = 1 ;
         AV60GXV1 = 1 ;
         while ( AV60GXV1 <= AV54TFServicioEstado_Sels.size() )
         {
            AV55TFServicioEstado_Sel = (String)AV54TFServicioEstado_Sels.elementAt(-1+AV60GXV1) ;
            if ( AV56i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomainestado.getDescription(httpContext,(String)AV55TFServicioEstado_Sel) );
            AV56i = (long)(AV56i+1) ;
            AV60GXV1 = (int)(AV60GXV1+1) ;
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("ServicioWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("ServicioWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV61GXV2 = 1 ;
      while ( AV61GXV2 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV61GXV2));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV61GXV2 = (int)(AV61GXV2+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV63Serviciowwds_1_filterfulltext = AV19FilterFullText ;
      AV64Serviciowwds_2_tfservicioid = AV35TFServicioId ;
      AV65Serviciowwds_3_tfservicioid_to = AV36TFServicioId_To ;
      AV66Serviciowwds_4_tfservicionombre = AV37TFServicioNombre ;
      AV67Serviciowwds_5_tfservicionombre_sel = AV38TFServicioNombre_Sel ;
      AV68Serviciowwds_6_tfserviciodescripcion = AV39TFServicioDescripcion ;
      AV69Serviciowwds_7_tfserviciodescripcion_sel = AV40TFServicioDescripcion_Sel ;
      AV70Serviciowwds_8_tfserviciocosto = AV41TFServicioCosto ;
      AV71Serviciowwds_9_tfserviciocosto_to = AV42TFServicioCosto_To ;
      AV72Serviciowwds_10_tfserviciocategid = AV43TFServicioCategId ;
      AV73Serviciowwds_11_tfserviciocategid_to = AV44TFServicioCategId_To ;
      AV74Serviciowwds_12_tflaboratorioid = AV45TFLaboratorioId ;
      AV75Serviciowwds_13_tflaboratorioid_to = AV46TFLaboratorioId_To ;
      AV76Serviciowwds_14_tflaboratorionombre = AV47TFLaboratorioNombre ;
      AV77Serviciowwds_15_tflaboratorionombre_sel = AV48TFLaboratorioNombre_Sel ;
      AV78Serviciowwds_16_tfserviciocomision = AV49TFServicioComision ;
      AV79Serviciowwds_17_tfserviciocomision_to = AV50TFServicioComision_To ;
      AV80Serviciowwds_18_tfservicioobservacion = AV51TFServicioObservacion ;
      AV81Serviciowwds_19_tfservicioobservacion_sel = AV52TFServicioObservacion_Sel ;
      AV82Serviciowwds_20_tfservicioestado_sels = AV54TFServicioEstado_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A286ServicioEstado ,
                                           AV82Serviciowwds_20_tfservicioestado_sels ,
                                           AV63Serviciowwds_1_filterfulltext ,
                                           Short.valueOf(AV64Serviciowwds_2_tfservicioid) ,
                                           Short.valueOf(AV65Serviciowwds_3_tfservicioid_to) ,
                                           AV67Serviciowwds_5_tfservicionombre_sel ,
                                           AV66Serviciowwds_4_tfservicionombre ,
                                           AV69Serviciowwds_7_tfserviciodescripcion_sel ,
                                           AV68Serviciowwds_6_tfserviciodescripcion ,
                                           AV70Serviciowwds_8_tfserviciocosto ,
                                           AV71Serviciowwds_9_tfserviciocosto_to ,
                                           Short.valueOf(AV72Serviciowwds_10_tfserviciocategid) ,
                                           Short.valueOf(AV73Serviciowwds_11_tfserviciocategid_to) ,
                                           Short.valueOf(AV74Serviciowwds_12_tflaboratorioid) ,
                                           Short.valueOf(AV75Serviciowwds_13_tflaboratorioid_to) ,
                                           AV77Serviciowwds_15_tflaboratorionombre_sel ,
                                           AV76Serviciowwds_14_tflaboratorionombre ,
                                           Short.valueOf(AV78Serviciowwds_16_tfserviciocomision) ,
                                           Short.valueOf(AV79Serviciowwds_17_tfserviciocomision_to) ,
                                           AV81Serviciowwds_19_tfservicioobservacion_sel ,
                                           AV80Serviciowwds_18_tfservicioobservacion ,
                                           Integer.valueOf(AV82Serviciowwds_20_tfservicioestado_sels.size()) ,
                                           Short.valueOf(A27ServicioId) ,
                                           A281ServicioNombre ,
                                           A282ServicioDescripcion ,
                                           A283ServicioCosto ,
                                           Short.valueOf(A52ServicioCategId) ,
                                           Short.valueOf(A40LaboratorioId) ,
                                           A165LaboratorioNombre ,
                                           Short.valueOf(A284ServicioComision) ,
                                           A285ServicioObservacion ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV63Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV63Serviciowwds_1_filterfulltext), "%", "") ;
      lV63Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV63Serviciowwds_1_filterfulltext), "%", "") ;
      lV63Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV63Serviciowwds_1_filterfulltext), "%", "") ;
      lV63Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV63Serviciowwds_1_filterfulltext), "%", "") ;
      lV63Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV63Serviciowwds_1_filterfulltext), "%", "") ;
      lV63Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV63Serviciowwds_1_filterfulltext), "%", "") ;
      lV63Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV63Serviciowwds_1_filterfulltext), "%", "") ;
      lV63Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV63Serviciowwds_1_filterfulltext), "%", "") ;
      lV63Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV63Serviciowwds_1_filterfulltext), "%", "") ;
      lV63Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV63Serviciowwds_1_filterfulltext), "%", "") ;
      lV63Serviciowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV63Serviciowwds_1_filterfulltext), "%", "") ;
      lV66Serviciowwds_4_tfservicionombre = GXutil.concat( GXutil.rtrim( AV66Serviciowwds_4_tfservicionombre), "%", "") ;
      lV68Serviciowwds_6_tfserviciodescripcion = GXutil.concat( GXutil.rtrim( AV68Serviciowwds_6_tfserviciodescripcion), "%", "") ;
      lV76Serviciowwds_14_tflaboratorionombre = GXutil.concat( GXutil.rtrim( AV76Serviciowwds_14_tflaboratorionombre), "%", "") ;
      lV80Serviciowwds_18_tfservicioobservacion = GXutil.concat( GXutil.rtrim( AV80Serviciowwds_18_tfservicioobservacion), "%", "") ;
      /* Using cursor P00572 */
      pr_default.execute(0, new Object[] {lV63Serviciowwds_1_filterfulltext, lV63Serviciowwds_1_filterfulltext, lV63Serviciowwds_1_filterfulltext, lV63Serviciowwds_1_filterfulltext, lV63Serviciowwds_1_filterfulltext, lV63Serviciowwds_1_filterfulltext, lV63Serviciowwds_1_filterfulltext, lV63Serviciowwds_1_filterfulltext, lV63Serviciowwds_1_filterfulltext, lV63Serviciowwds_1_filterfulltext, lV63Serviciowwds_1_filterfulltext, Short.valueOf(AV64Serviciowwds_2_tfservicioid), Short.valueOf(AV65Serviciowwds_3_tfservicioid_to), lV66Serviciowwds_4_tfservicionombre, AV67Serviciowwds_5_tfservicionombre_sel, lV68Serviciowwds_6_tfserviciodescripcion, AV69Serviciowwds_7_tfserviciodescripcion_sel, AV70Serviciowwds_8_tfserviciocosto, AV71Serviciowwds_9_tfserviciocosto_to, Short.valueOf(AV72Serviciowwds_10_tfserviciocategid), Short.valueOf(AV73Serviciowwds_11_tfserviciocategid_to), Short.valueOf(AV74Serviciowwds_12_tflaboratorioid), Short.valueOf(AV75Serviciowwds_13_tflaboratorioid_to), lV76Serviciowwds_14_tflaboratorionombre, AV77Serviciowwds_15_tflaboratorionombre_sel, Short.valueOf(AV78Serviciowwds_16_tfserviciocomision), Short.valueOf(AV79Serviciowwds_17_tfserviciocomision_to), lV80Serviciowwds_18_tfservicioobservacion, AV81Serviciowwds_19_tfservicioobservacion_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A284ServicioComision = P00572_A284ServicioComision[0] ;
         A40LaboratorioId = P00572_A40LaboratorioId[0] ;
         A52ServicioCategId = P00572_A52ServicioCategId[0] ;
         A283ServicioCosto = P00572_A283ServicioCosto[0] ;
         A27ServicioId = P00572_A27ServicioId[0] ;
         A286ServicioEstado = P00572_A286ServicioEstado[0] ;
         A285ServicioObservacion = P00572_A285ServicioObservacion[0] ;
         A165LaboratorioNombre = P00572_A165LaboratorioNombre[0] ;
         A282ServicioDescripcion = P00572_A282ServicioDescripcion[0] ;
         A281ServicioNombre = P00572_A281ServicioNombre[0] ;
         A40LaboratorioId = P00572_A40LaboratorioId[0] ;
         A165LaboratorioNombre = P00572_A165LaboratorioNombre[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV32VisibleColumnCount = 0 ;
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A27ServicioId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A281ServicioNombre, GXv_char7) ;
            serviciowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A282ServicioDescripcion, GXv_char7) ;
            serviciowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A283ServicioCosto)) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A52ServicioCategId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A40LaboratorioId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A165LaboratorioNombre, GXv_char7) ;
            serviciowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A284ServicioComision );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A285ServicioObservacion, GXv_char7) ;
            serviciowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomainestado.getDescription(httpContext,(String)A286ServicioEstado) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S182 ();
         if ( returnInSub )
         {
            pr_default.close(0);
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
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ServicioId", "", "Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ServicioNombre", "", "Nombre", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ServicioDescripcion", "", "Descripcion", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ServicioCosto", "", "Costo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ServicioCategId", "", "Servicio Categ Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LaboratorioId", "", "Laboratorio Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LaboratorioNombre", "", "Laboratorio Nombre", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ServicioComision", "", "Comision", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ServicioObservacion", "", "Observacion", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ServicioEstado", "", "Estado", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV28UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "ServicioWWColumnsSelector", GXv_char7) ;
      serviciowwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("ServicioWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ServicioWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("ServicioWWGridState"), null, null);
      }
      AV17OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV18OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV83GXV3 = 1 ;
      while ( AV83GXV3 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV83GXV3));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV19FilterFullText = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOID") == 0 )
         {
            AV35TFServicioId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFServicioId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIONOMBRE") == 0 )
         {
            AV37TFServicioNombre = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIONOMBRE_SEL") == 0 )
         {
            AV38TFServicioNombre_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIODESCRIPCION") == 0 )
         {
            AV39TFServicioDescripcion = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIODESCRIPCION_SEL") == 0 )
         {
            AV40TFServicioDescripcion_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOCOSTO") == 0 )
         {
            AV41TFServicioCosto = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV42TFServicioCosto_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOCATEGID") == 0 )
         {
            AV43TFServicioCategId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV44TFServicioCategId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIOID") == 0 )
         {
            AV45TFLaboratorioId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV46TFLaboratorioId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIONOMBRE") == 0 )
         {
            AV47TFLaboratorioNombre = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLABORATORIONOMBRE_SEL") == 0 )
         {
            AV48TFLaboratorioNombre_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOCOMISION") == 0 )
         {
            AV49TFServicioComision = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV50TFServicioComision_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOOBSERVACION") == 0 )
         {
            AV51TFServicioObservacion = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOOBSERVACION_SEL") == 0 )
         {
            AV52TFServicioObservacion_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSERVICIOESTADO_SEL") == 0 )
         {
            AV53TFServicioEstado_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV54TFServicioEstado_Sels.fromJSonString(AV53TFServicioEstado_SelsJson, null);
         }
         AV83GXV3 = (int)(AV83GXV3+1) ;
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
      this.aP0[0] = serviciowwexport.this.AV12Filename;
      this.aP1[0] = serviciowwexport.this.AV13ErrorMessage;
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
      AV59Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV19FilterFullText = "" ;
      AV38TFServicioNombre_Sel = "" ;
      AV37TFServicioNombre = "" ;
      AV40TFServicioDescripcion_Sel = "" ;
      AV39TFServicioDescripcion = "" ;
      AV41TFServicioCosto = DecimalUtil.ZERO ;
      AV42TFServicioCosto_To = DecimalUtil.ZERO ;
      AV48TFLaboratorioNombre_Sel = "" ;
      AV47TFLaboratorioNombre = "" ;
      AV52TFServicioObservacion_Sel = "" ;
      AV51TFServicioObservacion = "" ;
      AV54TFServicioEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV55TFServicioEstado_Sel = "" ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A281ServicioNombre = "" ;
      A282ServicioDescripcion = "" ;
      A283ServicioCosto = DecimalUtil.ZERO ;
      A165LaboratorioNombre = "" ;
      A285ServicioObservacion = "" ;
      A286ServicioEstado = "" ;
      AV63Serviciowwds_1_filterfulltext = "" ;
      AV66Serviciowwds_4_tfservicionombre = "" ;
      AV67Serviciowwds_5_tfservicionombre_sel = "" ;
      AV68Serviciowwds_6_tfserviciodescripcion = "" ;
      AV69Serviciowwds_7_tfserviciodescripcion_sel = "" ;
      AV70Serviciowwds_8_tfserviciocosto = DecimalUtil.ZERO ;
      AV71Serviciowwds_9_tfserviciocosto_to = DecimalUtil.ZERO ;
      AV76Serviciowwds_14_tflaboratorionombre = "" ;
      AV77Serviciowwds_15_tflaboratorionombre_sel = "" ;
      AV80Serviciowwds_18_tfservicioobservacion = "" ;
      AV81Serviciowwds_19_tfservicioobservacion_sel = "" ;
      AV82Serviciowwds_20_tfservicioestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV63Serviciowwds_1_filterfulltext = "" ;
      lV66Serviciowwds_4_tfservicionombre = "" ;
      lV68Serviciowwds_6_tfserviciodescripcion = "" ;
      lV76Serviciowwds_14_tflaboratorionombre = "" ;
      lV80Serviciowwds_18_tfservicioobservacion = "" ;
      P00572_A284ServicioComision = new short[1] ;
      P00572_A40LaboratorioId = new short[1] ;
      P00572_A52ServicioCategId = new short[1] ;
      P00572_A283ServicioCosto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00572_A27ServicioId = new short[1] ;
      P00572_A286ServicioEstado = new String[] {""} ;
      P00572_A285ServicioObservacion = new String[] {""} ;
      P00572_A165LaboratorioNombre = new String[] {""} ;
      P00572_A282ServicioDescripcion = new String[] {""} ;
      P00572_A281ServicioNombre = new String[] {""} ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV53TFServicioEstado_SelsJson = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.serviciowwexport__default(),
         new Object[] {
             new Object[] {
            P00572_A284ServicioComision, P00572_A40LaboratorioId, P00572_A52ServicioCategId, P00572_A283ServicioCosto, P00572_A27ServicioId, P00572_A286ServicioEstado, P00572_A285ServicioObservacion, P00572_A165LaboratorioNombre, P00572_A282ServicioDescripcion, P00572_A281ServicioNombre
            }
         }
      );
      AV59Pgmname = "ServicioWWExport" ;
      /* GeneXus formulas. */
      AV59Pgmname = "ServicioWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV35TFServicioId ;
   private short AV36TFServicioId_To ;
   private short AV43TFServicioCategId ;
   private short AV44TFServicioCategId_To ;
   private short AV45TFLaboratorioId ;
   private short AV46TFLaboratorioId_To ;
   private short AV49TFServicioComision ;
   private short AV50TFServicioComision_To ;
   private short GXv_int5[] ;
   private short A27ServicioId ;
   private short A52ServicioCategId ;
   private short A40LaboratorioId ;
   private short A284ServicioComision ;
   private short AV64Serviciowwds_2_tfservicioid ;
   private short AV65Serviciowwds_3_tfservicioid_to ;
   private short AV72Serviciowwds_10_tfserviciocategid ;
   private short AV73Serviciowwds_11_tfserviciocategid_to ;
   private short AV74Serviciowwds_12_tflaboratorioid ;
   private short AV75Serviciowwds_13_tflaboratorioid_to ;
   private short AV78Serviciowwds_16_tfserviciocomision ;
   private short AV79Serviciowwds_17_tfserviciocomision_to ;
   private short AV17OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV60GXV1 ;
   private int AV61GXV2 ;
   private int AV82Serviciowwds_20_tfservicioestado_sels_size ;
   private int AV83GXV3 ;
   private long AV56i ;
   private long AV32VisibleColumnCount ;
   private java.math.BigDecimal AV41TFServicioCosto ;
   private java.math.BigDecimal AV42TFServicioCosto_To ;
   private java.math.BigDecimal A283ServicioCosto ;
   private java.math.BigDecimal AV70Serviciowwds_8_tfserviciocosto ;
   private java.math.BigDecimal AV71Serviciowwds_9_tfserviciocosto_to ;
   private String AV59Pgmname ;
   private String AV55TFServicioEstado_Sel ;
   private String A286ServicioEstado ;
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
   private String AV53TFServicioEstado_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV19FilterFullText ;
   private String AV38TFServicioNombre_Sel ;
   private String AV37TFServicioNombre ;
   private String AV40TFServicioDescripcion_Sel ;
   private String AV39TFServicioDescripcion ;
   private String AV48TFLaboratorioNombre_Sel ;
   private String AV47TFLaboratorioNombre ;
   private String AV52TFServicioObservacion_Sel ;
   private String AV51TFServicioObservacion ;
   private String A281ServicioNombre ;
   private String A282ServicioDescripcion ;
   private String A165LaboratorioNombre ;
   private String A285ServicioObservacion ;
   private String AV63Serviciowwds_1_filterfulltext ;
   private String AV66Serviciowwds_4_tfservicionombre ;
   private String AV67Serviciowwds_5_tfservicionombre_sel ;
   private String AV68Serviciowwds_6_tfserviciodescripcion ;
   private String AV69Serviciowwds_7_tfserviciodescripcion_sel ;
   private String AV76Serviciowwds_14_tflaboratorionombre ;
   private String AV77Serviciowwds_15_tflaboratorionombre_sel ;
   private String AV80Serviciowwds_18_tfservicioobservacion ;
   private String AV81Serviciowwds_19_tfservicioobservacion_sel ;
   private String lV63Serviciowwds_1_filterfulltext ;
   private String lV66Serviciowwds_4_tfservicionombre ;
   private String lV68Serviciowwds_6_tfserviciodescripcion ;
   private String lV76Serviciowwds_14_tflaboratorionombre ;
   private String lV80Serviciowwds_18_tfservicioobservacion ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV54TFServicioEstado_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P00572_A284ServicioComision ;
   private short[] P00572_A40LaboratorioId ;
   private short[] P00572_A52ServicioCategId ;
   private java.math.BigDecimal[] P00572_A283ServicioCosto ;
   private short[] P00572_A27ServicioId ;
   private String[] P00572_A286ServicioEstado ;
   private String[] P00572_A285ServicioObservacion ;
   private String[] P00572_A165LaboratorioNombre ;
   private String[] P00572_A282ServicioDescripcion ;
   private String[] P00572_A281ServicioNombre ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV82Serviciowwds_20_tfservicioestado_sels ;
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

final  class serviciowwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00572( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A286ServicioEstado ,
                                          GXSimpleCollection<String> AV82Serviciowwds_20_tfservicioestado_sels ,
                                          String AV63Serviciowwds_1_filterfulltext ,
                                          short AV64Serviciowwds_2_tfservicioid ,
                                          short AV65Serviciowwds_3_tfservicioid_to ,
                                          String AV67Serviciowwds_5_tfservicionombre_sel ,
                                          String AV66Serviciowwds_4_tfservicionombre ,
                                          String AV69Serviciowwds_7_tfserviciodescripcion_sel ,
                                          String AV68Serviciowwds_6_tfserviciodescripcion ,
                                          java.math.BigDecimal AV70Serviciowwds_8_tfserviciocosto ,
                                          java.math.BigDecimal AV71Serviciowwds_9_tfserviciocosto_to ,
                                          short AV72Serviciowwds_10_tfserviciocategid ,
                                          short AV73Serviciowwds_11_tfserviciocategid_to ,
                                          short AV74Serviciowwds_12_tflaboratorioid ,
                                          short AV75Serviciowwds_13_tflaboratorioid_to ,
                                          String AV77Serviciowwds_15_tflaboratorionombre_sel ,
                                          String AV76Serviciowwds_14_tflaboratorionombre ,
                                          short AV78Serviciowwds_16_tfserviciocomision ,
                                          short AV79Serviciowwds_17_tfserviciocomision_to ,
                                          String AV81Serviciowwds_19_tfservicioobservacion_sel ,
                                          String AV80Serviciowwds_18_tfservicioobservacion ,
                                          int AV82Serviciowwds_20_tfservicioestado_sels_size ,
                                          short A27ServicioId ,
                                          String A281ServicioNombre ,
                                          String A282ServicioDescripcion ,
                                          java.math.BigDecimal A283ServicioCosto ,
                                          short A52ServicioCategId ,
                                          short A40LaboratorioId ,
                                          String A165LaboratorioNombre ,
                                          short A284ServicioComision ,
                                          String A285ServicioObservacion ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[29];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T1.[ServicioComision], T2.[LaboratorioId], T1.[ServicioCategId], T1.[ServicioCosto], T1.[ServicioId], T1.[ServicioEstado], T1.[ServicioObservacion], T3.[LaboratorioNombre]," ;
      scmdbuf += " T1.[ServicioDescripcion], T1.[ServicioNombre] FROM (([Servicio] T1 INNER JOIN [ServicioCateg] T2 ON T2.[ServicioCategId] = T1.[ServicioCategId]) INNER JOIN [Laboratorio]" ;
      scmdbuf += " T3 ON T3.[LaboratorioId] = T2.[LaboratorioId])" ;
      if ( ! (GXutil.strcmp("", AV63Serviciowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[ServicioId] AS decimal(4,0))) like '%' + ?) or ( T1.[ServicioNombre] like '%' + ?) or ( T1.[ServicioDescripcion] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[ServicioCosto] AS decimal(6,2))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[ServicioCategId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T2.[LaboratorioId] AS decimal(4,0))) like '%' + ?) or ( T3.[LaboratorioNombre] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[ServicioComision] AS decimal(4,0))) like '%' + ?) or ( T1.[ServicioObservacion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[ServicioEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[ServicioEstado] = 'I'))");
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
      if ( ! (0==AV64Serviciowwds_2_tfservicioid) )
      {
         addWhere(sWhereString, "(T1.[ServicioId] >= ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( ! (0==AV65Serviciowwds_3_tfservicioid_to) )
      {
         addWhere(sWhereString, "(T1.[ServicioId] <= ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV67Serviciowwds_5_tfservicionombre_sel)==0) && ( ! (GXutil.strcmp("", AV66Serviciowwds_4_tfservicionombre)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioNombre] like ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV67Serviciowwds_5_tfservicionombre_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioNombre] = ?)");
      }
      else
      {
         GXv_int10[14] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV69Serviciowwds_7_tfserviciodescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV68Serviciowwds_6_tfserviciodescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioDescripcion] like ?)");
      }
      else
      {
         GXv_int10[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV69Serviciowwds_7_tfserviciodescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioDescripcion] = ?)");
      }
      else
      {
         GXv_int10[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV70Serviciowwds_8_tfserviciocosto)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioCosto] >= ?)");
      }
      else
      {
         GXv_int10[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV71Serviciowwds_9_tfserviciocosto_to)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioCosto] <= ?)");
      }
      else
      {
         GXv_int10[18] = (byte)(1) ;
      }
      if ( ! (0==AV72Serviciowwds_10_tfserviciocategid) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategId] >= ?)");
      }
      else
      {
         GXv_int10[19] = (byte)(1) ;
      }
      if ( ! (0==AV73Serviciowwds_11_tfserviciocategid_to) )
      {
         addWhere(sWhereString, "(T1.[ServicioCategId] <= ?)");
      }
      else
      {
         GXv_int10[20] = (byte)(1) ;
      }
      if ( ! (0==AV74Serviciowwds_12_tflaboratorioid) )
      {
         addWhere(sWhereString, "(T2.[LaboratorioId] >= ?)");
      }
      else
      {
         GXv_int10[21] = (byte)(1) ;
      }
      if ( ! (0==AV75Serviciowwds_13_tflaboratorioid_to) )
      {
         addWhere(sWhereString, "(T2.[LaboratorioId] <= ?)");
      }
      else
      {
         GXv_int10[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV77Serviciowwds_15_tflaboratorionombre_sel)==0) && ( ! (GXutil.strcmp("", AV76Serviciowwds_14_tflaboratorionombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[LaboratorioNombre] like ?)");
      }
      else
      {
         GXv_int10[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV77Serviciowwds_15_tflaboratorionombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[LaboratorioNombre] = ?)");
      }
      else
      {
         GXv_int10[24] = (byte)(1) ;
      }
      if ( ! (0==AV78Serviciowwds_16_tfserviciocomision) )
      {
         addWhere(sWhereString, "(T1.[ServicioComision] >= ?)");
      }
      else
      {
         GXv_int10[25] = (byte)(1) ;
      }
      if ( ! (0==AV79Serviciowwds_17_tfserviciocomision_to) )
      {
         addWhere(sWhereString, "(T1.[ServicioComision] <= ?)");
      }
      else
      {
         GXv_int10[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV81Serviciowwds_19_tfservicioobservacion_sel)==0) && ( ! (GXutil.strcmp("", AV80Serviciowwds_18_tfservicioobservacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ServicioObservacion] like ?)");
      }
      else
      {
         GXv_int10[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV81Serviciowwds_19_tfservicioobservacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ServicioObservacion] = ?)");
      }
      else
      {
         GXv_int10[28] = (byte)(1) ;
      }
      if ( AV82Serviciowwds_20_tfservicioestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV82Serviciowwds_20_tfservicioestado_sels, "T1.[ServicioEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ServicioNombre]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ServicioNombre] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ServicioId]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ServicioId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ServicioDescripcion]" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ServicioDescripcion] DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ServicioCosto]" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ServicioCosto] DESC" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ServicioCategId]" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ServicioCategId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[LaboratorioId]" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[LaboratorioId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[LaboratorioNombre]" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[LaboratorioNombre] DESC" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ServicioComision]" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ServicioComision] DESC" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ServicioObservacion]" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ServicioObservacion] DESC" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ServicioEstado]" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ServicioEstado] DESC" ;
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
                  return conditional_P00572(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).shortValue() , (String)dynConstraints[15] , (String)dynConstraints[16] , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).shortValue() , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).shortValue() , (String)dynConstraints[23] , (String)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).shortValue() , (String)dynConstraints[28] , ((Number) dynConstraints[29]).shortValue() , (String)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Boolean) dynConstraints[32]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00572", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
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
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[40]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[41]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 40);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 40);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[46], 2);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[47], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[48]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[49]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[50]).shortValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[51]).shortValue());
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[54]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[55]).shortValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               return;
      }
   }

}

