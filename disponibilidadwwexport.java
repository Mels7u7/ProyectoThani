package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class disponibilidadwwexport extends GXProcedure
{
   public disponibilidadwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( disponibilidadwwexport.class ), "" );
   }

   public disponibilidadwwexport( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      disponibilidadwwexport.this.aP1 = new String[] {""};
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
      disponibilidadwwexport.this.aP0 = aP0;
      disponibilidadwwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDisponibilidad", GXv_boolean2) ;
      disponibilidadwwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV89Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "DisponibilidadWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
         disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV19FilterFullText, GXv_char7) ;
         disponibilidadwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      if ( ! ( (0==AV35TFDisponibilidadId) && (0==AV36TFDisponibilidadId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFDisponibilidadId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFDisponibilidadId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV38TFEventId_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFEventId_Sel, GXv_char7) ;
         disponibilidadwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV37TFEventId)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Id") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV37TFEventId, GXv_char7) ;
            disponibilidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV40TFDisponibilidadDescription_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Description") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFDisponibilidadDescription_Sel, GXv_char7) ;
         disponibilidadwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV39TFDisponibilidadDescription)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Description") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV39TFDisponibilidadDescription, GXv_char7) ;
            disponibilidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV41TFProfesionalId) && (0==AV42TFProfesionalId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Profesional Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV41TFProfesionalId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV42TFProfesionalId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV44TFProfesionalApellidoPaterno_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Apellido Paterno") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV44TFProfesionalApellidoPaterno_Sel, GXv_char7) ;
         disponibilidadwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV43TFProfesionalApellidoPaterno)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Apellido Paterno") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV43TFProfesionalApellidoPaterno, GXv_char7) ;
            disponibilidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV46TFProfesionalApellidoMaterno_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Apellido Materno") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV46TFProfesionalApellidoMaterno_Sel, GXv_char7) ;
         disponibilidadwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV45TFProfesionalApellidoMaterno)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Apellido Materno") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV45TFProfesionalApellidoMaterno, GXv_char7) ;
            disponibilidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV48TFProfesionalNombres_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nombres") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV48TFProfesionalNombres_Sel, GXv_char7) ;
         disponibilidadwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV47TFProfesionalNombres)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nombres") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV47TFProfesionalNombres, GXv_char7) ;
            disponibilidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV50TFProfesionalNombreCompleto_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nombre Completo") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV50TFProfesionalNombreCompleto_Sel, GXv_char7) ;
         disponibilidadwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV49TFProfesionalNombreCompleto)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nombre Completo") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV49TFProfesionalNombreCompleto, GXv_char7) ;
            disponibilidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV52TFProfesionalCOP_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "CMP") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV52TFProfesionalCOP_Sel, GXv_char7) ;
         disponibilidadwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV51TFProfesionalCOP)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "CMP") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV51TFProfesionalCOP, GXv_char7) ;
            disponibilidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV53TFDisponibilidadFecha)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV54TFDisponibilidadFecha_To)) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Fecha") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV53TFDisponibilidadFecha );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime8 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV54TFDisponibilidadFecha_To );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime8 );
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), AV55TFDisponibilidadHoraInicio) && GXutil.dateCompare(GXutil.nullDate(), AV56TFDisponibilidadHoraInicio_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Hora Inicio") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( localUtil.format( AV55TFDisponibilidadHoraInicio, "99:99") );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setText( localUtil.format( AV56TFDisponibilidadHoraInicio_To, "99:99") );
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), AV57TFDisponibilidadHoraFin) && GXutil.dateCompare(GXutil.nullDate(), AV58TFDisponibilidadHoraFin_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Hora Fin") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( localUtil.format( AV57TFDisponibilidadHoraFin, "99:99") );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setText( localUtil.format( AV58TFDisponibilidadHoraFin_To, "99:99") );
      }
      if ( ! ( (0==AV59TFEspecialidadId) && (0==AV60TFEspecialidadId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Especialidad Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV59TFEspecialidadId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV60TFEspecialidadId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV62TFEspecialidadCodigo_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Especialidad Codigo") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV62TFEspecialidadCodigo_Sel, GXv_char7) ;
         disponibilidadwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV61TFEspecialidadCodigo)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Especialidad Codigo") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV61TFEspecialidadCodigo, GXv_char7) ;
            disponibilidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV64TFEspecialidadNombre_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Especialidad Nombre") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV64TFEspecialidadNombre_Sel, GXv_char7) ;
         disponibilidadwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV63TFEspecialidadNombre)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Especialidad Nombre") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV63TFEspecialidadNombre, GXv_char7) ;
            disponibilidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV73TFDisponibilidadUser) && (0==AV74TFDisponibilidadUser_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "User") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV73TFDisponibilidadUser );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV74TFDisponibilidadUser_To );
      }
      if ( ! ( ( AV76TFDisponibilidadEstado_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Estado") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV83i = 1 ;
         AV90GXV1 = 1 ;
         while ( AV90GXV1 <= AV76TFDisponibilidadEstado_Sels.size() )
         {
            AV77TFDisponibilidadEstado_Sel = (String)AV76TFDisponibilidadEstado_Sels.elementAt(-1+AV90GXV1) ;
            if ( AV83i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomainestado.getDescription(httpContext,(String)AV77TFDisponibilidadEstado_Sel) );
            AV83i = (long)(AV83i+1) ;
            AV90GXV1 = (int)(AV90GXV1+1) ;
         }
      }
      if ( ! ( ( AV79TFDisponibilidadEstadoCita_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Estado Cita") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV83i = 1 ;
         AV91GXV2 = 1 ;
         while ( AV91GXV2 <= AV79TFDisponibilidadEstadoCita_Sels.size() )
         {
            AV80TFDisponibilidadEstadoCita_Sel = (String)AV79TFDisponibilidadEstadoCita_Sels.elementAt(-1+AV91GXV2) ;
            if ( AV83i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomainestadodc.getDescription(httpContext,(String)AV80TFDisponibilidadEstadoCita_Sel) );
            AV83i = (long)(AV83i+1) ;
            AV91GXV2 = (int)(AV91GXV2+1) ;
         }
      }
      if ( ! ( (0==AV81TFDCitaId) && (0==AV82TFDCitaId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV81TFDCitaId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV82TFDCitaId_To );
      }
      if ( ! ( ( AV85TFDisponibilidadTipoCita_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Tipo Cita") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         disponibilidadwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV83i = 1 ;
         AV92GXV3 = 1 ;
         while ( AV92GXV3 <= AV85TFDisponibilidadTipoCita_Sels.size() )
         {
            AV86TFDisponibilidadTipoCita_Sel = (String)AV85TFDisponibilidadTipoCita_Sels.elementAt(-1+AV92GXV3) ;
            if ( AV83i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomaintipocita.getDescription(httpContext,(String)AV86TFDisponibilidadTipoCita_Sel) );
            AV83i = (long)(AV83i+1) ;
            AV92GXV3 = (int)(AV92GXV3+1) ;
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("DisponibilidadWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("DisponibilidadWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV93GXV4 = 1 ;
      while ( AV93GXV4 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV93GXV4));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV93GXV4 = (int)(AV93GXV4+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV95Disponibilidadwwds_1_filterfulltext = AV19FilterFullText ;
      AV96Disponibilidadwwds_2_tfdisponibilidadid = AV35TFDisponibilidadId ;
      AV97Disponibilidadwwds_3_tfdisponibilidadid_to = AV36TFDisponibilidadId_To ;
      AV98Disponibilidadwwds_4_tfeventid = AV37TFEventId ;
      AV99Disponibilidadwwds_5_tfeventid_sel = AV38TFEventId_Sel ;
      AV100Disponibilidadwwds_6_tfdisponibilidaddescription = AV39TFDisponibilidadDescription ;
      AV101Disponibilidadwwds_7_tfdisponibilidaddescription_sel = AV40TFDisponibilidadDescription_Sel ;
      AV102Disponibilidadwwds_8_tfprofesionalid = AV41TFProfesionalId ;
      AV103Disponibilidadwwds_9_tfprofesionalid_to = AV42TFProfesionalId_To ;
      AV104Disponibilidadwwds_10_tfprofesionalapellidopaterno = AV43TFProfesionalApellidoPaterno ;
      AV105Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel = AV44TFProfesionalApellidoPaterno_Sel ;
      AV106Disponibilidadwwds_12_tfprofesionalapellidomaterno = AV45TFProfesionalApellidoMaterno ;
      AV107Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel = AV46TFProfesionalApellidoMaterno_Sel ;
      AV108Disponibilidadwwds_14_tfprofesionalnombres = AV47TFProfesionalNombres ;
      AV109Disponibilidadwwds_15_tfprofesionalnombres_sel = AV48TFProfesionalNombres_Sel ;
      AV110Disponibilidadwwds_16_tfprofesionalnombrecompleto = AV49TFProfesionalNombreCompleto ;
      AV111Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel = AV50TFProfesionalNombreCompleto_Sel ;
      AV112Disponibilidadwwds_18_tfprofesionalcop = AV51TFProfesionalCOP ;
      AV113Disponibilidadwwds_19_tfprofesionalcop_sel = AV52TFProfesionalCOP_Sel ;
      AV114Disponibilidadwwds_20_tfdisponibilidadfecha = AV53TFDisponibilidadFecha ;
      AV115Disponibilidadwwds_21_tfdisponibilidadfecha_to = AV54TFDisponibilidadFecha_To ;
      AV116Disponibilidadwwds_22_tfdisponibilidadhorainicio = AV55TFDisponibilidadHoraInicio ;
      AV117Disponibilidadwwds_23_tfdisponibilidadhorainicio_to = AV56TFDisponibilidadHoraInicio_To ;
      AV118Disponibilidadwwds_24_tfdisponibilidadhorafin = AV57TFDisponibilidadHoraFin ;
      AV119Disponibilidadwwds_25_tfdisponibilidadhorafin_to = AV58TFDisponibilidadHoraFin_To ;
      AV120Disponibilidadwwds_26_tfespecialidadid = AV59TFEspecialidadId ;
      AV121Disponibilidadwwds_27_tfespecialidadid_to = AV60TFEspecialidadId_To ;
      AV122Disponibilidadwwds_28_tfespecialidadcodigo = AV61TFEspecialidadCodigo ;
      AV123Disponibilidadwwds_29_tfespecialidadcodigo_sel = AV62TFEspecialidadCodigo_Sel ;
      AV124Disponibilidadwwds_30_tfespecialidadnombre = AV63TFEspecialidadNombre ;
      AV125Disponibilidadwwds_31_tfespecialidadnombre_sel = AV64TFEspecialidadNombre_Sel ;
      AV126Disponibilidadwwds_32_tfdisponibilidaduser = AV73TFDisponibilidadUser ;
      AV127Disponibilidadwwds_33_tfdisponibilidaduser_to = AV74TFDisponibilidadUser_To ;
      AV128Disponibilidadwwds_34_tfdisponibilidadestado_sels = AV76TFDisponibilidadEstado_Sels ;
      AV129Disponibilidadwwds_35_tfdisponibilidadestadocita_sels = AV79TFDisponibilidadEstadoCita_Sels ;
      AV130Disponibilidadwwds_36_tfdcitaid = AV81TFDCitaId ;
      AV131Disponibilidadwwds_37_tfdcitaid_to = AV82TFDCitaId_To ;
      AV132Disponibilidadwwds_38_tfdisponibilidadtipocita_sels = AV85TFDisponibilidadTipoCita_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A136DisponibilidadEstado ,
                                           AV128Disponibilidadwwds_34_tfdisponibilidadestado_sels ,
                                           A139DisponibilidadEstadoCita ,
                                           AV129Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ,
                                           A298DisponibilidadTipoCita ,
                                           AV132Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ,
                                           Integer.valueOf(AV96Disponibilidadwwds_2_tfdisponibilidadid) ,
                                           Integer.valueOf(AV97Disponibilidadwwds_3_tfdisponibilidadid_to) ,
                                           AV99Disponibilidadwwds_5_tfeventid_sel ,
                                           AV98Disponibilidadwwds_4_tfeventid ,
                                           AV101Disponibilidadwwds_7_tfdisponibilidaddescription_sel ,
                                           AV100Disponibilidadwwds_6_tfdisponibilidaddescription ,
                                           Integer.valueOf(AV102Disponibilidadwwds_8_tfprofesionalid) ,
                                           Integer.valueOf(AV103Disponibilidadwwds_9_tfprofesionalid_to) ,
                                           AV105Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ,
                                           AV104Disponibilidadwwds_10_tfprofesionalapellidopaterno ,
                                           AV107Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ,
                                           AV106Disponibilidadwwds_12_tfprofesionalapellidomaterno ,
                                           AV109Disponibilidadwwds_15_tfprofesionalnombres_sel ,
                                           AV108Disponibilidadwwds_14_tfprofesionalnombres ,
                                           AV111Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ,
                                           AV110Disponibilidadwwds_16_tfprofesionalnombrecompleto ,
                                           AV113Disponibilidadwwds_19_tfprofesionalcop_sel ,
                                           AV112Disponibilidadwwds_18_tfprofesionalcop ,
                                           AV114Disponibilidadwwds_20_tfdisponibilidadfecha ,
                                           AV115Disponibilidadwwds_21_tfdisponibilidadfecha_to ,
                                           AV116Disponibilidadwwds_22_tfdisponibilidadhorainicio ,
                                           AV117Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ,
                                           AV118Disponibilidadwwds_24_tfdisponibilidadhorafin ,
                                           AV119Disponibilidadwwds_25_tfdisponibilidadhorafin_to ,
                                           Short.valueOf(AV120Disponibilidadwwds_26_tfespecialidadid) ,
                                           Short.valueOf(AV121Disponibilidadwwds_27_tfespecialidadid_to) ,
                                           AV123Disponibilidadwwds_29_tfespecialidadcodigo_sel ,
                                           AV122Disponibilidadwwds_28_tfespecialidadcodigo ,
                                           AV125Disponibilidadwwds_31_tfespecialidadnombre_sel ,
                                           AV124Disponibilidadwwds_30_tfespecialidadnombre ,
                                           Integer.valueOf(AV126Disponibilidadwwds_32_tfdisponibilidaduser) ,
                                           Integer.valueOf(AV127Disponibilidadwwds_33_tfdisponibilidaduser_to) ,
                                           Integer.valueOf(AV128Disponibilidadwwds_34_tfdisponibilidadestado_sels.size()) ,
                                           Integer.valueOf(AV129Disponibilidadwwds_35_tfdisponibilidadestadocita_sels.size()) ,
                                           Integer.valueOf(AV132Disponibilidadwwds_38_tfdisponibilidadtipocita_sels.size()) ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A133EventId ,
                                           A134DisponibilidadDescription ,
                                           Integer.valueOf(A31ProfesionalId) ,
                                           A85ProfesionalApellidoPaterno ,
                                           A86ProfesionalApellidoMaterno ,
                                           A84ProfesionalNombres ,
                                           A88ProfesionalCOP ,
                                           A67DisponibilidadFecha ,
                                           A69DisponibilidadHoraInicio ,
                                           A135DisponibilidadHoraFin ,
                                           Short.valueOf(A32EspecialidadId) ,
                                           A140EspecialidadCodigo ,
                                           A71EspecialidadNombre ,
                                           Integer.valueOf(A137DisponibilidadUser) ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) ,
                                           AV95Disponibilidadwwds_1_filterfulltext ,
                                           A83ProfesionalNombreCompleto ,
                                           Integer.valueOf(A138DCitaId) ,
                                           Integer.valueOf(AV130Disponibilidadwwds_36_tfdcitaid) ,
                                           Integer.valueOf(AV131Disponibilidadwwds_37_tfdcitaid_to) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN,
                                           TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV95Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV95Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV95Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV95Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV95Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV95Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV95Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV95Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV95Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV95Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV95Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV95Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV95Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV95Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV95Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV95Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV95Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV95Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV95Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV95Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV95Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV95Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV98Disponibilidadwwds_4_tfeventid = GXutil.padr( GXutil.rtrim( AV98Disponibilidadwwds_4_tfeventid), 20, "%") ;
      lV100Disponibilidadwwds_6_tfdisponibilidaddescription = GXutil.concat( GXutil.rtrim( AV100Disponibilidadwwds_6_tfdisponibilidaddescription), "%", "") ;
      lV104Disponibilidadwwds_10_tfprofesionalapellidopaterno = GXutil.concat( GXutil.rtrim( AV104Disponibilidadwwds_10_tfprofesionalapellidopaterno), "%", "") ;
      lV106Disponibilidadwwds_12_tfprofesionalapellidomaterno = GXutil.concat( GXutil.rtrim( AV106Disponibilidadwwds_12_tfprofesionalapellidomaterno), "%", "") ;
      lV108Disponibilidadwwds_14_tfprofesionalnombres = GXutil.concat( GXutil.rtrim( AV108Disponibilidadwwds_14_tfprofesionalnombres), "%", "") ;
      lV110Disponibilidadwwds_16_tfprofesionalnombrecompleto = GXutil.concat( GXutil.rtrim( AV110Disponibilidadwwds_16_tfprofesionalnombrecompleto), "%", "") ;
      lV112Disponibilidadwwds_18_tfprofesionalcop = GXutil.concat( GXutil.rtrim( AV112Disponibilidadwwds_18_tfprofesionalcop), "%", "") ;
      lV122Disponibilidadwwds_28_tfespecialidadcodigo = GXutil.concat( GXutil.rtrim( AV122Disponibilidadwwds_28_tfespecialidadcodigo), "%", "") ;
      lV124Disponibilidadwwds_30_tfespecialidadnombre = GXutil.concat( GXutil.rtrim( AV124Disponibilidadwwds_30_tfespecialidadnombre), "%", "") ;
      /* Using cursor P004J3 */
      pr_default.execute(0, new Object[] {AV95Disponibilidadwwds_1_filterfulltext, lV95Disponibilidadwwds_1_filterfulltext, lV95Disponibilidadwwds_1_filterfulltext, lV95Disponibilidadwwds_1_filterfulltext, lV95Disponibilidadwwds_1_filterfulltext, lV95Disponibilidadwwds_1_filterfulltext, lV95Disponibilidadwwds_1_filterfulltext, lV95Disponibilidadwwds_1_filterfulltext, lV95Disponibilidadwwds_1_filterfulltext, lV95Disponibilidadwwds_1_filterfulltext, lV95Disponibilidadwwds_1_filterfulltext, lV95Disponibilidadwwds_1_filterfulltext, lV95Disponibilidadwwds_1_filterfulltext, lV95Disponibilidadwwds_1_filterfulltext, lV95Disponibilidadwwds_1_filterfulltext, lV95Disponibilidadwwds_1_filterfulltext, lV95Disponibilidadwwds_1_filterfulltext, lV95Disponibilidadwwds_1_filterfulltext, lV95Disponibilidadwwds_1_filterfulltext, lV95Disponibilidadwwds_1_filterfulltext, lV95Disponibilidadwwds_1_filterfulltext, lV95Disponibilidadwwds_1_filterfulltext, lV95Disponibilidadwwds_1_filterfulltext, Integer.valueOf(AV130Disponibilidadwwds_36_tfdcitaid), Integer.valueOf(AV130Disponibilidadwwds_36_tfdcitaid), Integer.valueOf(AV131Disponibilidadwwds_37_tfdcitaid_to), Integer.valueOf(AV131Disponibilidadwwds_37_tfdcitaid_to), Integer.valueOf(AV96Disponibilidadwwds_2_tfdisponibilidadid), Integer.valueOf(AV97Disponibilidadwwds_3_tfdisponibilidadid_to), lV98Disponibilidadwwds_4_tfeventid, AV99Disponibilidadwwds_5_tfeventid_sel, lV100Disponibilidadwwds_6_tfdisponibilidaddescription, AV101Disponibilidadwwds_7_tfdisponibilidaddescription_sel, Integer.valueOf(AV102Disponibilidadwwds_8_tfprofesionalid), Integer.valueOf(AV103Disponibilidadwwds_9_tfprofesionalid_to), lV104Disponibilidadwwds_10_tfprofesionalapellidopaterno, AV105Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel, lV106Disponibilidadwwds_12_tfprofesionalapellidomaterno, AV107Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel, lV108Disponibilidadwwds_14_tfprofesionalnombres, AV109Disponibilidadwwds_15_tfprofesionalnombres_sel, lV110Disponibilidadwwds_16_tfprofesionalnombrecompleto, AV111Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel, lV112Disponibilidadwwds_18_tfprofesionalcop, AV113Disponibilidadwwds_19_tfprofesionalcop_sel, AV114Disponibilidadwwds_20_tfdisponibilidadfecha, AV115Disponibilidadwwds_21_tfdisponibilidadfecha_to, AV116Disponibilidadwwds_22_tfdisponibilidadhorainicio, AV117Disponibilidadwwds_23_tfdisponibilidadhorainicio_to, AV118Disponibilidadwwds_24_tfdisponibilidadhorafin, AV119Disponibilidadwwds_25_tfdisponibilidadhorafin_to, Short.valueOf(AV120Disponibilidadwwds_26_tfespecialidadid), Short.valueOf(AV121Disponibilidadwwds_27_tfespecialidadid_to), lV122Disponibilidadwwds_28_tfespecialidadcodigo, AV123Disponibilidadwwds_29_tfespecialidadcodigo_sel, lV124Disponibilidadwwds_30_tfespecialidadnombre, AV125Disponibilidadwwds_31_tfespecialidadnombre_sel, Integer.valueOf(AV126Disponibilidadwwds_32_tfdisponibilidaduser), Integer.valueOf(AV127Disponibilidadwwds_33_tfdisponibilidaduser_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A137DisponibilidadUser = P004J3_A137DisponibilidadUser[0] ;
         A32EspecialidadId = P004J3_A32EspecialidadId[0] ;
         A135DisponibilidadHoraFin = P004J3_A135DisponibilidadHoraFin[0] ;
         n135DisponibilidadHoraFin = P004J3_n135DisponibilidadHoraFin[0] ;
         A69DisponibilidadHoraInicio = P004J3_A69DisponibilidadHoraInicio[0] ;
         n69DisponibilidadHoraInicio = P004J3_n69DisponibilidadHoraInicio[0] ;
         A67DisponibilidadFecha = P004J3_A67DisponibilidadFecha[0] ;
         n67DisponibilidadFecha = P004J3_n67DisponibilidadFecha[0] ;
         A31ProfesionalId = P004J3_A31ProfesionalId[0] ;
         A34DisponibilidadId = P004J3_A34DisponibilidadId[0] ;
         A298DisponibilidadTipoCita = P004J3_A298DisponibilidadTipoCita[0] ;
         A139DisponibilidadEstadoCita = P004J3_A139DisponibilidadEstadoCita[0] ;
         A136DisponibilidadEstado = P004J3_A136DisponibilidadEstado[0] ;
         A71EspecialidadNombre = P004J3_A71EspecialidadNombre[0] ;
         A140EspecialidadCodigo = P004J3_A140EspecialidadCodigo[0] ;
         A88ProfesionalCOP = P004J3_A88ProfesionalCOP[0] ;
         A83ProfesionalNombreCompleto = P004J3_A83ProfesionalNombreCompleto[0] ;
         A134DisponibilidadDescription = P004J3_A134DisponibilidadDescription[0] ;
         A133EventId = P004J3_A133EventId[0] ;
         A138DCitaId = P004J3_A138DCitaId[0] ;
         n138DCitaId = P004J3_n138DCitaId[0] ;
         A84ProfesionalNombres = P004J3_A84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P004J3_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P004J3_A86ProfesionalApellidoMaterno[0] ;
         A71EspecialidadNombre = P004J3_A71EspecialidadNombre[0] ;
         A140EspecialidadCodigo = P004J3_A140EspecialidadCodigo[0] ;
         A88ProfesionalCOP = P004J3_A88ProfesionalCOP[0] ;
         A84ProfesionalNombres = P004J3_A84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P004J3_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P004J3_A86ProfesionalApellidoMaterno[0] ;
         A138DCitaId = P004J3_A138DCitaId[0] ;
         n138DCitaId = P004J3_n138DCitaId[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV32VisibleColumnCount = 0 ;
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A34DisponibilidadId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A133EventId, GXv_char7) ;
            disponibilidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A134DisponibilidadDescription, GXv_char7) ;
            disponibilidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A31ProfesionalId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A85ProfesionalApellidoPaterno, GXv_char7) ;
            disponibilidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A86ProfesionalApellidoMaterno, GXv_char7) ;
            disponibilidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A84ProfesionalNombres, GXv_char7) ;
            disponibilidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A83ProfesionalNombreCompleto, GXv_char7) ;
            disponibilidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A88ProfesionalCOP, GXv_char7) ;
            disponibilidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_dtime8 = GXutil.resetTime( A67DisponibilidadFecha );
            AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setDate( GXt_dtime8 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( localUtil.format( A69DisponibilidadHoraInicio, "99:99") );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( localUtil.format( A135DisponibilidadHoraFin, "99:99") );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A32EspecialidadId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A140EspecialidadCodigo, GXv_char7) ;
            disponibilidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A71EspecialidadNombre, GXv_char7) ;
            disponibilidadwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+16)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A137DisponibilidadUser );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+17)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomainestado.getDescription(httpContext,(String)A136DisponibilidadEstado) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+18)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomainestadodc.getDescription(httpContext,(String)A139DisponibilidadEstadoCita) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+19)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A138DCitaId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+20)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomaintipocita.getDescription(httpContext,(String)A298DisponibilidadTipoCita) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S182 ();
         if ( returnInSub )
         {
            pr_default.close(0);
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
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "DisponibilidadId", "", "Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "EventId", "", "Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "DisponibilidadDescription", "", "Description", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalId", "", "Profesional Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalApellidoPaterno", "", "Apellido Paterno", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalApellidoMaterno", "", "Apellido Materno", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalNombres", "", "Nombres", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalNombreCompleto", "", "Nombre Completo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "ProfesionalCOP", "", "CMP", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "DisponibilidadFecha", "", "Fecha", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "DisponibilidadHoraInicio", "", "Hora Inicio", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "DisponibilidadHoraFin", "", "Hora Fin", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "EspecialidadId", "", "Especialidad Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "EspecialidadCodigo", "", "Especialidad Codigo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "EspecialidadNombre", "", "Especialidad Nombre", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "DisponibilidadUser", "", "User", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "DisponibilidadEstado", "", "Estado", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "DisponibilidadEstadoCita", "", "Estado Cita", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "DCitaId", "", "Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "DisponibilidadTipoCita", "", "Tipo Cita", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXt_char6 = AV28UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "DisponibilidadWWColumnsSelector", GXv_char7) ;
      disponibilidadwwexport.this.GXt_char6 = GXv_char7[0] ;
      AV28UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV28UserCustomValue)==0) ) )
      {
         AV25ColumnsSelectorAux.fromxml(AV28UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
         new com.projectthani.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, GXv_SdtWWPColumnsSelector10) ;
         AV25ColumnsSelectorAux = GXv_SdtWWPColumnsSelector9[0] ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("DisponibilidadWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "DisponibilidadWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("DisponibilidadWWGridState"), null, null);
      }
      AV17OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV18OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV133GXV5 = 1 ;
      while ( AV133GXV5 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV133GXV5));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV19FilterFullText = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADID") == 0 )
         {
            AV35TFDisponibilidadId = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFDisponibilidadId_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEVENTID") == 0 )
         {
            AV37TFEventId = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEVENTID_SEL") == 0 )
         {
            AV38TFEventId_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADDESCRIPTION") == 0 )
         {
            AV39TFDisponibilidadDescription = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADDESCRIPTION_SEL") == 0 )
         {
            AV40TFDisponibilidadDescription_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALID") == 0 )
         {
            AV41TFProfesionalId = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV42TFProfesionalId_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALAPELLIDOPATERNO") == 0 )
         {
            AV43TFProfesionalApellidoPaterno = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALAPELLIDOPATERNO_SEL") == 0 )
         {
            AV44TFProfesionalApellidoPaterno_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALAPELLIDOMATERNO") == 0 )
         {
            AV45TFProfesionalApellidoMaterno = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALAPELLIDOMATERNO_SEL") == 0 )
         {
            AV46TFProfesionalApellidoMaterno_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNOMBRES") == 0 )
         {
            AV47TFProfesionalNombres = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNOMBRES_SEL") == 0 )
         {
            AV48TFProfesionalNombres_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNOMBRECOMPLETO") == 0 )
         {
            AV49TFProfesionalNombreCompleto = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNOMBRECOMPLETO_SEL") == 0 )
         {
            AV50TFProfesionalNombreCompleto_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCOP") == 0 )
         {
            AV51TFProfesionalCOP = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCOP_SEL") == 0 )
         {
            AV52TFProfesionalCOP_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADFECHA") == 0 )
         {
            AV53TFDisponibilidadFecha = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            AV54TFDisponibilidadFecha_To = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADHORAINICIO") == 0 )
         {
            AV55TFDisponibilidadHoraInicio = GXutil.resetDate(localUtil.ctot( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3)) ;
            AV56TFDisponibilidadHoraInicio_To = GXutil.resetDate(localUtil.ctot( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3)) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADHORAFIN") == 0 )
         {
            AV57TFDisponibilidadHoraFin = GXutil.resetDate(localUtil.ctot( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3)) ;
            AV58TFDisponibilidadHoraFin_To = GXutil.resetDate(localUtil.ctot( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3)) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADID") == 0 )
         {
            AV59TFEspecialidadId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV60TFEspecialidadId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADCODIGO") == 0 )
         {
            AV61TFEspecialidadCodigo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADCODIGO_SEL") == 0 )
         {
            AV62TFEspecialidadCodigo_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADNOMBRE") == 0 )
         {
            AV63TFEspecialidadNombre = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADNOMBRE_SEL") == 0 )
         {
            AV64TFEspecialidadNombre_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADUSER") == 0 )
         {
            AV73TFDisponibilidadUser = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV74TFDisponibilidadUser_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADESTADO_SEL") == 0 )
         {
            AV75TFDisponibilidadEstado_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV76TFDisponibilidadEstado_Sels.fromJSonString(AV75TFDisponibilidadEstado_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADESTADOCITA_SEL") == 0 )
         {
            AV78TFDisponibilidadEstadoCita_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV79TFDisponibilidadEstadoCita_Sels.fromJSonString(AV78TFDisponibilidadEstadoCita_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCITAID") == 0 )
         {
            AV81TFDCitaId = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV82TFDCitaId_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADTIPOCITA_SEL") == 0 )
         {
            AV84TFDisponibilidadTipoCita_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV85TFDisponibilidadTipoCita_Sels.fromJSonString(AV84TFDisponibilidadTipoCita_SelsJson, null);
         }
         AV133GXV5 = (int)(AV133GXV5+1) ;
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
      this.aP0[0] = disponibilidadwwexport.this.AV12Filename;
      this.aP1[0] = disponibilidadwwexport.this.AV13ErrorMessage;
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
      AV89Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV19FilterFullText = "" ;
      AV38TFEventId_Sel = "" ;
      AV37TFEventId = "" ;
      AV40TFDisponibilidadDescription_Sel = "" ;
      AV39TFDisponibilidadDescription = "" ;
      AV44TFProfesionalApellidoPaterno_Sel = "" ;
      AV43TFProfesionalApellidoPaterno = "" ;
      AV46TFProfesionalApellidoMaterno_Sel = "" ;
      AV45TFProfesionalApellidoMaterno = "" ;
      AV48TFProfesionalNombres_Sel = "" ;
      AV47TFProfesionalNombres = "" ;
      AV50TFProfesionalNombreCompleto_Sel = "" ;
      AV49TFProfesionalNombreCompleto = "" ;
      AV52TFProfesionalCOP_Sel = "" ;
      AV51TFProfesionalCOP = "" ;
      AV53TFDisponibilidadFecha = GXutil.nullDate() ;
      AV54TFDisponibilidadFecha_To = GXutil.nullDate() ;
      AV55TFDisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      AV56TFDisponibilidadHoraInicio_To = GXutil.resetTime( GXutil.nullDate() );
      AV57TFDisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      AV58TFDisponibilidadHoraFin_To = GXutil.resetTime( GXutil.nullDate() );
      AV62TFEspecialidadCodigo_Sel = "" ;
      AV61TFEspecialidadCodigo = "" ;
      AV64TFEspecialidadNombre_Sel = "" ;
      AV63TFEspecialidadNombre = "" ;
      AV76TFDisponibilidadEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV77TFDisponibilidadEstado_Sel = "" ;
      AV79TFDisponibilidadEstadoCita_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV80TFDisponibilidadEstadoCita_Sel = "" ;
      AV85TFDisponibilidadTipoCita_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV86TFDisponibilidadTipoCita_Sel = "" ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A133EventId = "" ;
      A134DisponibilidadDescription = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      A84ProfesionalNombres = "" ;
      A83ProfesionalNombreCompleto = "" ;
      A88ProfesionalCOP = "" ;
      A67DisponibilidadFecha = GXutil.nullDate() ;
      A69DisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      A135DisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      A140EspecialidadCodigo = "" ;
      A71EspecialidadNombre = "" ;
      A136DisponibilidadEstado = "" ;
      A139DisponibilidadEstadoCita = "" ;
      A298DisponibilidadTipoCita = "" ;
      AV95Disponibilidadwwds_1_filterfulltext = "" ;
      AV98Disponibilidadwwds_4_tfeventid = "" ;
      AV99Disponibilidadwwds_5_tfeventid_sel = "" ;
      AV100Disponibilidadwwds_6_tfdisponibilidaddescription = "" ;
      AV101Disponibilidadwwds_7_tfdisponibilidaddescription_sel = "" ;
      AV104Disponibilidadwwds_10_tfprofesionalapellidopaterno = "" ;
      AV105Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel = "" ;
      AV106Disponibilidadwwds_12_tfprofesionalapellidomaterno = "" ;
      AV107Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel = "" ;
      AV108Disponibilidadwwds_14_tfprofesionalnombres = "" ;
      AV109Disponibilidadwwds_15_tfprofesionalnombres_sel = "" ;
      AV110Disponibilidadwwds_16_tfprofesionalnombrecompleto = "" ;
      AV111Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel = "" ;
      AV112Disponibilidadwwds_18_tfprofesionalcop = "" ;
      AV113Disponibilidadwwds_19_tfprofesionalcop_sel = "" ;
      AV114Disponibilidadwwds_20_tfdisponibilidadfecha = GXutil.nullDate() ;
      AV115Disponibilidadwwds_21_tfdisponibilidadfecha_to = GXutil.nullDate() ;
      AV116Disponibilidadwwds_22_tfdisponibilidadhorainicio = GXutil.resetTime( GXutil.nullDate() );
      AV117Disponibilidadwwds_23_tfdisponibilidadhorainicio_to = GXutil.resetTime( GXutil.nullDate() );
      AV118Disponibilidadwwds_24_tfdisponibilidadhorafin = GXutil.resetTime( GXutil.nullDate() );
      AV119Disponibilidadwwds_25_tfdisponibilidadhorafin_to = GXutil.resetTime( GXutil.nullDate() );
      AV122Disponibilidadwwds_28_tfespecialidadcodigo = "" ;
      AV123Disponibilidadwwds_29_tfespecialidadcodigo_sel = "" ;
      AV124Disponibilidadwwds_30_tfespecialidadnombre = "" ;
      AV125Disponibilidadwwds_31_tfespecialidadnombre_sel = "" ;
      AV128Disponibilidadwwds_34_tfdisponibilidadestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV129Disponibilidadwwds_35_tfdisponibilidadestadocita_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV132Disponibilidadwwds_38_tfdisponibilidadtipocita_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      lV95Disponibilidadwwds_1_filterfulltext = "" ;
      scmdbuf = "" ;
      lV98Disponibilidadwwds_4_tfeventid = "" ;
      lV100Disponibilidadwwds_6_tfdisponibilidaddescription = "" ;
      lV104Disponibilidadwwds_10_tfprofesionalapellidopaterno = "" ;
      lV106Disponibilidadwwds_12_tfprofesionalapellidomaterno = "" ;
      lV108Disponibilidadwwds_14_tfprofesionalnombres = "" ;
      lV110Disponibilidadwwds_16_tfprofesionalnombrecompleto = "" ;
      lV112Disponibilidadwwds_18_tfprofesionalcop = "" ;
      lV122Disponibilidadwwds_28_tfespecialidadcodigo = "" ;
      lV124Disponibilidadwwds_30_tfespecialidadnombre = "" ;
      P004J3_A137DisponibilidadUser = new int[1] ;
      P004J3_A32EspecialidadId = new short[1] ;
      P004J3_A135DisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      P004J3_n135DisponibilidadHoraFin = new boolean[] {false} ;
      P004J3_A69DisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P004J3_n69DisponibilidadHoraInicio = new boolean[] {false} ;
      P004J3_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P004J3_n67DisponibilidadFecha = new boolean[] {false} ;
      P004J3_A31ProfesionalId = new int[1] ;
      P004J3_A34DisponibilidadId = new int[1] ;
      P004J3_A298DisponibilidadTipoCita = new String[] {""} ;
      P004J3_A139DisponibilidadEstadoCita = new String[] {""} ;
      P004J3_A136DisponibilidadEstado = new String[] {""} ;
      P004J3_A71EspecialidadNombre = new String[] {""} ;
      P004J3_A140EspecialidadCodigo = new String[] {""} ;
      P004J3_A88ProfesionalCOP = new String[] {""} ;
      P004J3_A83ProfesionalNombreCompleto = new String[] {""} ;
      P004J3_A134DisponibilidadDescription = new String[] {""} ;
      P004J3_A133EventId = new String[] {""} ;
      P004J3_A138DCitaId = new int[1] ;
      P004J3_n138DCitaId = new boolean[] {false} ;
      P004J3_A84ProfesionalNombres = new String[] {""} ;
      P004J3_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P004J3_A86ProfesionalApellidoMaterno = new String[] {""} ;
      GXt_dtime8 = GXutil.resetTime( GXutil.nullDate() );
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector10 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV75TFDisponibilidadEstado_SelsJson = "" ;
      AV78TFDisponibilidadEstadoCita_SelsJson = "" ;
      AV84TFDisponibilidadTipoCita_SelsJson = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.disponibilidadwwexport__default(),
         new Object[] {
             new Object[] {
            P004J3_A137DisponibilidadUser, P004J3_A32EspecialidadId, P004J3_A135DisponibilidadHoraFin, P004J3_n135DisponibilidadHoraFin, P004J3_A69DisponibilidadHoraInicio, P004J3_n69DisponibilidadHoraInicio, P004J3_A67DisponibilidadFecha, P004J3_n67DisponibilidadFecha, P004J3_A31ProfesionalId, P004J3_A34DisponibilidadId,
            P004J3_A298DisponibilidadTipoCita, P004J3_A139DisponibilidadEstadoCita, P004J3_A136DisponibilidadEstado, P004J3_A71EspecialidadNombre, P004J3_A140EspecialidadCodigo, P004J3_A88ProfesionalCOP, P004J3_A83ProfesionalNombreCompleto, P004J3_A134DisponibilidadDescription, P004J3_A133EventId, P004J3_A138DCitaId,
            P004J3_n138DCitaId, P004J3_A84ProfesionalNombres, P004J3_A85ProfesionalApellidoPaterno, P004J3_A86ProfesionalApellidoMaterno
            }
         }
      );
      AV89Pgmname = "DisponibilidadWWExport" ;
      /* GeneXus formulas. */
      AV89Pgmname = "DisponibilidadWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV59TFEspecialidadId ;
   private short AV60TFEspecialidadId_To ;
   private short GXv_int5[] ;
   private short A32EspecialidadId ;
   private short AV120Disponibilidadwwds_26_tfespecialidadid ;
   private short AV121Disponibilidadwwds_27_tfespecialidadid_to ;
   private short AV17OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV35TFDisponibilidadId ;
   private int AV36TFDisponibilidadId_To ;
   private int AV41TFProfesionalId ;
   private int AV42TFProfesionalId_To ;
   private int AV73TFDisponibilidadUser ;
   private int AV74TFDisponibilidadUser_To ;
   private int AV90GXV1 ;
   private int AV91GXV2 ;
   private int AV81TFDCitaId ;
   private int AV82TFDCitaId_To ;
   private int AV92GXV3 ;
   private int AV93GXV4 ;
   private int A34DisponibilidadId ;
   private int A31ProfesionalId ;
   private int A137DisponibilidadUser ;
   private int A138DCitaId ;
   private int AV96Disponibilidadwwds_2_tfdisponibilidadid ;
   private int AV97Disponibilidadwwds_3_tfdisponibilidadid_to ;
   private int AV102Disponibilidadwwds_8_tfprofesionalid ;
   private int AV103Disponibilidadwwds_9_tfprofesionalid_to ;
   private int AV126Disponibilidadwwds_32_tfdisponibilidaduser ;
   private int AV127Disponibilidadwwds_33_tfdisponibilidaduser_to ;
   private int AV130Disponibilidadwwds_36_tfdcitaid ;
   private int AV131Disponibilidadwwds_37_tfdcitaid_to ;
   private int AV128Disponibilidadwwds_34_tfdisponibilidadestado_sels_size ;
   private int AV129Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size ;
   private int AV132Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size ;
   private int AV133GXV5 ;
   private long AV83i ;
   private long AV32VisibleColumnCount ;
   private String AV89Pgmname ;
   private String AV38TFEventId_Sel ;
   private String AV37TFEventId ;
   private String AV77TFDisponibilidadEstado_Sel ;
   private String AV86TFDisponibilidadTipoCita_Sel ;
   private String A133EventId ;
   private String A136DisponibilidadEstado ;
   private String A298DisponibilidadTipoCita ;
   private String AV98Disponibilidadwwds_4_tfeventid ;
   private String AV99Disponibilidadwwds_5_tfeventid_sel ;
   private String scmdbuf ;
   private String lV98Disponibilidadwwds_4_tfeventid ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private java.util.Date AV55TFDisponibilidadHoraInicio ;
   private java.util.Date AV56TFDisponibilidadHoraInicio_To ;
   private java.util.Date AV57TFDisponibilidadHoraFin ;
   private java.util.Date AV58TFDisponibilidadHoraFin_To ;
   private java.util.Date A69DisponibilidadHoraInicio ;
   private java.util.Date A135DisponibilidadHoraFin ;
   private java.util.Date AV116Disponibilidadwwds_22_tfdisponibilidadhorainicio ;
   private java.util.Date AV117Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ;
   private java.util.Date AV118Disponibilidadwwds_24_tfdisponibilidadhorafin ;
   private java.util.Date AV119Disponibilidadwwds_25_tfdisponibilidadhorafin_to ;
   private java.util.Date GXt_dtime8 ;
   private java.util.Date AV53TFDisponibilidadFecha ;
   private java.util.Date AV54TFDisponibilidadFecha_To ;
   private java.util.Date A67DisponibilidadFecha ;
   private java.util.Date AV114Disponibilidadwwds_20_tfdisponibilidadfecha ;
   private java.util.Date AV115Disponibilidadwwds_21_tfdisponibilidadfecha_to ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV18OrderedDsc ;
   private boolean n135DisponibilidadHoraFin ;
   private boolean n69DisponibilidadHoraInicio ;
   private boolean n67DisponibilidadFecha ;
   private boolean n138DCitaId ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV75TFDisponibilidadEstado_SelsJson ;
   private String AV78TFDisponibilidadEstadoCita_SelsJson ;
   private String AV84TFDisponibilidadTipoCita_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV19FilterFullText ;
   private String AV40TFDisponibilidadDescription_Sel ;
   private String AV39TFDisponibilidadDescription ;
   private String AV44TFProfesionalApellidoPaterno_Sel ;
   private String AV43TFProfesionalApellidoPaterno ;
   private String AV46TFProfesionalApellidoMaterno_Sel ;
   private String AV45TFProfesionalApellidoMaterno ;
   private String AV48TFProfesionalNombres_Sel ;
   private String AV47TFProfesionalNombres ;
   private String AV50TFProfesionalNombreCompleto_Sel ;
   private String AV49TFProfesionalNombreCompleto ;
   private String AV52TFProfesionalCOP_Sel ;
   private String AV51TFProfesionalCOP ;
   private String AV62TFEspecialidadCodigo_Sel ;
   private String AV61TFEspecialidadCodigo ;
   private String AV64TFEspecialidadNombre_Sel ;
   private String AV63TFEspecialidadNombre ;
   private String AV80TFDisponibilidadEstadoCita_Sel ;
   private String A134DisponibilidadDescription ;
   private String A85ProfesionalApellidoPaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private String A84ProfesionalNombres ;
   private String A83ProfesionalNombreCompleto ;
   private String A88ProfesionalCOP ;
   private String A140EspecialidadCodigo ;
   private String A71EspecialidadNombre ;
   private String A139DisponibilidadEstadoCita ;
   private String AV95Disponibilidadwwds_1_filterfulltext ;
   private String AV100Disponibilidadwwds_6_tfdisponibilidaddescription ;
   private String AV101Disponibilidadwwds_7_tfdisponibilidaddescription_sel ;
   private String AV104Disponibilidadwwds_10_tfprofesionalapellidopaterno ;
   private String AV105Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ;
   private String AV106Disponibilidadwwds_12_tfprofesionalapellidomaterno ;
   private String AV107Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ;
   private String AV108Disponibilidadwwds_14_tfprofesionalnombres ;
   private String AV109Disponibilidadwwds_15_tfprofesionalnombres_sel ;
   private String AV110Disponibilidadwwds_16_tfprofesionalnombrecompleto ;
   private String AV111Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ;
   private String AV112Disponibilidadwwds_18_tfprofesionalcop ;
   private String AV113Disponibilidadwwds_19_tfprofesionalcop_sel ;
   private String AV122Disponibilidadwwds_28_tfespecialidadcodigo ;
   private String AV123Disponibilidadwwds_29_tfespecialidadcodigo_sel ;
   private String AV124Disponibilidadwwds_30_tfespecialidadnombre ;
   private String AV125Disponibilidadwwds_31_tfespecialidadnombre_sel ;
   private String lV95Disponibilidadwwds_1_filterfulltext ;
   private String lV100Disponibilidadwwds_6_tfdisponibilidaddescription ;
   private String lV104Disponibilidadwwds_10_tfprofesionalapellidopaterno ;
   private String lV106Disponibilidadwwds_12_tfprofesionalapellidomaterno ;
   private String lV108Disponibilidadwwds_14_tfprofesionalnombres ;
   private String lV110Disponibilidadwwds_16_tfprofesionalnombrecompleto ;
   private String lV112Disponibilidadwwds_18_tfprofesionalcop ;
   private String lV122Disponibilidadwwds_28_tfespecialidadcodigo ;
   private String lV124Disponibilidadwwds_30_tfespecialidadnombre ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV76TFDisponibilidadEstado_Sels ;
   private GXSimpleCollection<String> AV85TFDisponibilidadTipoCita_Sels ;
   private GXSimpleCollection<String> AV79TFDisponibilidadEstadoCita_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private int[] P004J3_A137DisponibilidadUser ;
   private short[] P004J3_A32EspecialidadId ;
   private java.util.Date[] P004J3_A135DisponibilidadHoraFin ;
   private boolean[] P004J3_n135DisponibilidadHoraFin ;
   private java.util.Date[] P004J3_A69DisponibilidadHoraInicio ;
   private boolean[] P004J3_n69DisponibilidadHoraInicio ;
   private java.util.Date[] P004J3_A67DisponibilidadFecha ;
   private boolean[] P004J3_n67DisponibilidadFecha ;
   private int[] P004J3_A31ProfesionalId ;
   private int[] P004J3_A34DisponibilidadId ;
   private String[] P004J3_A298DisponibilidadTipoCita ;
   private String[] P004J3_A139DisponibilidadEstadoCita ;
   private String[] P004J3_A136DisponibilidadEstado ;
   private String[] P004J3_A71EspecialidadNombre ;
   private String[] P004J3_A140EspecialidadCodigo ;
   private String[] P004J3_A88ProfesionalCOP ;
   private String[] P004J3_A83ProfesionalNombreCompleto ;
   private String[] P004J3_A134DisponibilidadDescription ;
   private String[] P004J3_A133EventId ;
   private int[] P004J3_A138DCitaId ;
   private boolean[] P004J3_n138DCitaId ;
   private String[] P004J3_A84ProfesionalNombres ;
   private String[] P004J3_A85ProfesionalApellidoPaterno ;
   private String[] P004J3_A86ProfesionalApellidoMaterno ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV128Disponibilidadwwds_34_tfdisponibilidadestado_sels ;
   private GXSimpleCollection<String> AV132Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ;
   private GXSimpleCollection<String> AV129Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV24ColumnsSelector ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelectorAux ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column AV26ColumnsSelector_Column ;
}

final  class disponibilidadwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P004J3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A136DisponibilidadEstado ,
                                          GXSimpleCollection<String> AV128Disponibilidadwwds_34_tfdisponibilidadestado_sels ,
                                          String A139DisponibilidadEstadoCita ,
                                          GXSimpleCollection<String> AV129Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ,
                                          String A298DisponibilidadTipoCita ,
                                          GXSimpleCollection<String> AV132Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ,
                                          int AV96Disponibilidadwwds_2_tfdisponibilidadid ,
                                          int AV97Disponibilidadwwds_3_tfdisponibilidadid_to ,
                                          String AV99Disponibilidadwwds_5_tfeventid_sel ,
                                          String AV98Disponibilidadwwds_4_tfeventid ,
                                          String AV101Disponibilidadwwds_7_tfdisponibilidaddescription_sel ,
                                          String AV100Disponibilidadwwds_6_tfdisponibilidaddescription ,
                                          int AV102Disponibilidadwwds_8_tfprofesionalid ,
                                          int AV103Disponibilidadwwds_9_tfprofesionalid_to ,
                                          String AV105Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ,
                                          String AV104Disponibilidadwwds_10_tfprofesionalapellidopaterno ,
                                          String AV107Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ,
                                          String AV106Disponibilidadwwds_12_tfprofesionalapellidomaterno ,
                                          String AV109Disponibilidadwwds_15_tfprofesionalnombres_sel ,
                                          String AV108Disponibilidadwwds_14_tfprofesionalnombres ,
                                          String AV111Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ,
                                          String AV110Disponibilidadwwds_16_tfprofesionalnombrecompleto ,
                                          String AV113Disponibilidadwwds_19_tfprofesionalcop_sel ,
                                          String AV112Disponibilidadwwds_18_tfprofesionalcop ,
                                          java.util.Date AV114Disponibilidadwwds_20_tfdisponibilidadfecha ,
                                          java.util.Date AV115Disponibilidadwwds_21_tfdisponibilidadfecha_to ,
                                          java.util.Date AV116Disponibilidadwwds_22_tfdisponibilidadhorainicio ,
                                          java.util.Date AV117Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ,
                                          java.util.Date AV118Disponibilidadwwds_24_tfdisponibilidadhorafin ,
                                          java.util.Date AV119Disponibilidadwwds_25_tfdisponibilidadhorafin_to ,
                                          short AV120Disponibilidadwwds_26_tfespecialidadid ,
                                          short AV121Disponibilidadwwds_27_tfespecialidadid_to ,
                                          String AV123Disponibilidadwwds_29_tfespecialidadcodigo_sel ,
                                          String AV122Disponibilidadwwds_28_tfespecialidadcodigo ,
                                          String AV125Disponibilidadwwds_31_tfespecialidadnombre_sel ,
                                          String AV124Disponibilidadwwds_30_tfespecialidadnombre ,
                                          int AV126Disponibilidadwwds_32_tfdisponibilidaduser ,
                                          int AV127Disponibilidadwwds_33_tfdisponibilidaduser_to ,
                                          int AV128Disponibilidadwwds_34_tfdisponibilidadestado_sels_size ,
                                          int AV129Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size ,
                                          int AV132Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size ,
                                          int A34DisponibilidadId ,
                                          String A133EventId ,
                                          String A134DisponibilidadDescription ,
                                          int A31ProfesionalId ,
                                          String A85ProfesionalApellidoPaterno ,
                                          String A86ProfesionalApellidoMaterno ,
                                          String A84ProfesionalNombres ,
                                          String A88ProfesionalCOP ,
                                          java.util.Date A67DisponibilidadFecha ,
                                          java.util.Date A69DisponibilidadHoraInicio ,
                                          java.util.Date A135DisponibilidadHoraFin ,
                                          short A32EspecialidadId ,
                                          String A140EspecialidadCodigo ,
                                          String A71EspecialidadNombre ,
                                          int A137DisponibilidadUser ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc ,
                                          String AV95Disponibilidadwwds_1_filterfulltext ,
                                          String A83ProfesionalNombreCompleto ,
                                          int A138DCitaId ,
                                          int AV130Disponibilidadwwds_36_tfdcitaid ,
                                          int AV131Disponibilidadwwds_37_tfdcitaid_to )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[59];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T1.[DisponibilidadUser], T1.[EspecialidadId], T1.[DisponibilidadHoraFin], T1.[DisponibilidadHoraInicio], T1.[DisponibilidadFecha], T1.[ProfesionalId], T1.[DisponibilidadId]," ;
      scmdbuf += " T1.[DisponibilidadTipoCita], T1.[DisponibilidadEstadoCita], T1.[DisponibilidadEstado], T2.[EspecialidadNombre], T2.[EspecialidadCodigo], T3.[ProfesionalCOP], T3.[ProfesionalNombres]" ;
      scmdbuf += " + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] AS ProfesionalNombreCompleto, T1.[DisponibilidadDescription], T1.[EventId], COALESCE(" ;
      scmdbuf += " T4.[DCitaId], 0) AS DCitaId, T3.[ProfesionalNombres], T3.[ProfesionalApellidoPaterno], T3.[ProfesionalApellidoMaterno] FROM ((([Disponibilidad] T1 INNER JOIN [Especialidad]" ;
      scmdbuf += " T2 ON T2.[EspecialidadId] = T1.[EspecialidadId]) INNER JOIN [Profesional] T3 ON T3.[ProfesionalId] = T1.[ProfesionalId]) LEFT JOIN (SELECT MIN(T5.[CitaId]) AS DCitaId," ;
      scmdbuf += " T5.[SGCitaDisponibilidadId] FROM [Cita] T5,  [Disponibilidad] T6 WHERE (T5.[SGCitaDisponibilidadId] = T6.[DisponibilidadId]) AND (T5.[CitaEstado] = 'A') GROUP BY" ;
      scmdbuf += " T5.[SGCitaDisponibilidadId] ) T4 ON T4.[SGCitaDisponibilidadId] = T1.[DisponibilidadId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[EventId] like '%' + ?) or ( T1.[DisponibilidadDescription] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( T3.[ProfesionalApellidoPaterno] like '%' + ?) or ( T3.[ProfesionalApellidoMaterno] like '%' + ?) or ( T3.[ProfesionalNombres] like '%' + ?) or ( T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like '%' + ?) or ( T3.[ProfesionalCOP] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( T2.[EspecialidadCodigo] like '%' + ?) or ( T2.[EspecialidadNombre] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[DisponibilidadUser] AS decimal(6,0))) like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[DisponibilidadEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[DisponibilidadEstado] = 'I') or ( 'libre' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'L') or ( 'ocupado' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'O') or ( 'expiró' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'E') or ( CONVERT( char(6), CAST(COALESCE( T4.[DCitaId], 0) AS decimal(6,0))) like '%' + ?) or ( 'virtual' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'V') or ( 'en consultorio' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'P') or ( 'visita a domicilio' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'D')))");
      addWhere(sWhereString, "((? = convert(int, 0)) or ( COALESCE( T4.[DCitaId], 0) >= ?))");
      addWhere(sWhereString, "((? = convert(int, 0)) or ( COALESCE( T4.[DCitaId], 0) <= ?))");
      if ( ! (0==AV96Disponibilidadwwds_2_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int11[27] = (byte)(1) ;
      }
      if ( ! (0==AV97Disponibilidadwwds_3_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int11[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV99Disponibilidadwwds_5_tfeventid_sel)==0) && ( ! (GXutil.strcmp("", AV98Disponibilidadwwds_4_tfeventid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[EventId] like ?)");
      }
      else
      {
         GXv_int11[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV99Disponibilidadwwds_5_tfeventid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[EventId] = ?)");
      }
      else
      {
         GXv_int11[30] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV101Disponibilidadwwds_7_tfdisponibilidaddescription_sel)==0) && ( ! (GXutil.strcmp("", AV100Disponibilidadwwds_6_tfdisponibilidaddescription)==0) ) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadDescription] like ?)");
      }
      else
      {
         GXv_int11[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV101Disponibilidadwwds_7_tfdisponibilidaddescription_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadDescription] = ?)");
      }
      else
      {
         GXv_int11[32] = (byte)(1) ;
      }
      if ( ! (0==AV102Disponibilidadwwds_8_tfprofesionalid) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int11[33] = (byte)(1) ;
      }
      if ( ! (0==AV103Disponibilidadwwds_9_tfprofesionalid_to) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int11[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV105Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV104Disponibilidadwwds_10_tfprofesionalapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int11[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV105Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int11[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV107Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV106Disponibilidadwwds_12_tfprofesionalapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int11[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV107Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int11[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV109Disponibilidadwwds_15_tfprofesionalnombres_sel)==0) && ( ! (GXutil.strcmp("", AV108Disponibilidadwwds_14_tfprofesionalnombres)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] like ?)");
      }
      else
      {
         GXv_int11[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV109Disponibilidadwwds_15_tfprofesionalnombres_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] = ?)");
      }
      else
      {
         GXv_int11[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV111Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV110Disponibilidadwwds_16_tfprofesionalnombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int11[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV111Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int11[42] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV113Disponibilidadwwds_19_tfprofesionalcop_sel)==0) && ( ! (GXutil.strcmp("", AV112Disponibilidadwwds_18_tfprofesionalcop)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] like ?)");
      }
      else
      {
         GXv_int11[43] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV113Disponibilidadwwds_19_tfprofesionalcop_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] = ?)");
      }
      else
      {
         GXv_int11[44] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV114Disponibilidadwwds_20_tfdisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int11[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV115Disponibilidadwwds_21_tfdisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int11[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV116Disponibilidadwwds_22_tfdisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int11[47] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV117Disponibilidadwwds_23_tfdisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int11[48] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV118Disponibilidadwwds_24_tfdisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int11[49] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV119Disponibilidadwwds_25_tfdisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int11[50] = (byte)(1) ;
      }
      if ( ! (0==AV120Disponibilidadwwds_26_tfespecialidadid) )
      {
         addWhere(sWhereString, "(T1.[EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int11[51] = (byte)(1) ;
      }
      if ( ! (0==AV121Disponibilidadwwds_27_tfespecialidadid_to) )
      {
         addWhere(sWhereString, "(T1.[EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int11[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV123Disponibilidadwwds_29_tfespecialidadcodigo_sel)==0) && ( ! (GXutil.strcmp("", AV122Disponibilidadwwds_28_tfespecialidadcodigo)==0) ) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadCodigo] like ?)");
      }
      else
      {
         GXv_int11[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV123Disponibilidadwwds_29_tfespecialidadcodigo_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadCodigo] = ?)");
      }
      else
      {
         GXv_int11[54] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV125Disponibilidadwwds_31_tfespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV124Disponibilidadwwds_30_tfespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int11[55] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV125Disponibilidadwwds_31_tfespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int11[56] = (byte)(1) ;
      }
      if ( ! (0==AV126Disponibilidadwwds_32_tfdisponibilidaduser) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadUser] >= ?)");
      }
      else
      {
         GXv_int11[57] = (byte)(1) ;
      }
      if ( ! (0==AV127Disponibilidadwwds_33_tfdisponibilidaduser_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadUser] <= ?)");
      }
      else
      {
         GXv_int11[58] = (byte)(1) ;
      }
      if ( AV128Disponibilidadwwds_34_tfdisponibilidadestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV128Disponibilidadwwds_34_tfdisponibilidadestado_sels, "T1.[DisponibilidadEstado] IN (", ")")+")");
      }
      if ( AV129Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV129Disponibilidadwwds_35_tfdisponibilidadestadocita_sels, "T1.[DisponibilidadEstadoCita] IN (", ")")+")");
      }
      if ( AV132Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV132Disponibilidadwwds_38_tfdisponibilidadtipocita_sels, "T1.[DisponibilidadTipoCita] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadId]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[EventId]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[EventId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadDescription]" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadDescription] DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalId]" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[ProfesionalApellidoPaterno]" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[ProfesionalApellidoPaterno] DESC" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[ProfesionalApellidoMaterno]" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[ProfesionalApellidoMaterno] DESC" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[ProfesionalNombres]" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[ProfesionalNombres] DESC" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[ProfesionalCOP]" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[ProfesionalCOP] DESC" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadFecha]" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadFecha] DESC" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadHoraInicio]" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadHoraInicio] DESC" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadHoraFin]" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadHoraFin] DESC" ;
      }
      else if ( ( AV17OrderedBy == 12 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[EspecialidadId]" ;
      }
      else if ( ( AV17OrderedBy == 12 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[EspecialidadId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 13 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[EspecialidadCodigo]" ;
      }
      else if ( ( AV17OrderedBy == 13 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[EspecialidadCodigo] DESC" ;
      }
      else if ( ( AV17OrderedBy == 14 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[EspecialidadNombre]" ;
      }
      else if ( ( AV17OrderedBy == 14 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[EspecialidadNombre] DESC" ;
      }
      else if ( ( AV17OrderedBy == 15 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadUser]" ;
      }
      else if ( ( AV17OrderedBy == 15 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadUser] DESC" ;
      }
      else if ( ( AV17OrderedBy == 16 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadEstado]" ;
      }
      else if ( ( AV17OrderedBy == 16 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadEstado] DESC" ;
      }
      else if ( ( AV17OrderedBy == 17 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadEstadoCita]" ;
      }
      else if ( ( AV17OrderedBy == 17 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadEstadoCita] DESC" ;
      }
      else if ( ( AV17OrderedBy == 18 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadTipoCita]" ;
      }
      else if ( ( AV17OrderedBy == 18 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadTipoCita] DESC" ;
      }
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
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
                  return conditional_P004J3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (java.util.Date)dynConstraints[24] , (java.util.Date)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (java.util.Date)dynConstraints[27] , (java.util.Date)dynConstraints[28] , (java.util.Date)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).shortValue() , (String)dynConstraints[32] , (String)dynConstraints[33] , (String)dynConstraints[34] , (String)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , ((Number) dynConstraints[37]).intValue() , ((Number) dynConstraints[38]).intValue() , ((Number) dynConstraints[39]).intValue() , ((Number) dynConstraints[40]).intValue() , ((Number) dynConstraints[41]).intValue() , (String)dynConstraints[42] , (String)dynConstraints[43] , ((Number) dynConstraints[44]).intValue() , (String)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , (String)dynConstraints[48] , (java.util.Date)dynConstraints[49] , (java.util.Date)dynConstraints[50] , (java.util.Date)dynConstraints[51] , ((Number) dynConstraints[52]).shortValue() , (String)dynConstraints[53] , (String)dynConstraints[54] , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).shortValue() , ((Boolean) dynConstraints[57]).booleanValue() , (String)dynConstraints[58] , (String)dynConstraints[59] , ((Number) dynConstraints[60]).intValue() , ((Number) dynConstraints[61]).intValue() , ((Number) dynConstraints[62]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004J3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = GXutil.resetDate(rslt.getGXDateTime(3));
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[4])[0] = GXutil.resetDate(rslt.getGXDateTime(4));
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((int[]) buf[8])[0] = rslt.getInt(6);
               ((int[]) buf[9])[0] = rslt.getInt(7);
               ((String[]) buf[10])[0] = rslt.getString(8, 1);
               ((String[]) buf[11])[0] = rslt.getVarchar(9);
               ((String[]) buf[12])[0] = rslt.getString(10, 1);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getVarchar(14);
               ((String[]) buf[17])[0] = rslt.getVarchar(15);
               ((String[]) buf[18])[0] = rslt.getString(16, 20);
               ((int[]) buf[19])[0] = rslt.getInt(17);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getVarchar(18);
               ((String[]) buf[22])[0] = rslt.getVarchar(19);
               ((String[]) buf[23])[0] = rslt.getVarchar(20);
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
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[82]).intValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[83]).intValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[84]).intValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[85]).intValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[86]).intValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[87]).intValue());
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[88], 20);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[89], 20);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[92]).intValue());
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[93]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 50);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 50);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 50);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 50);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 50);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 50);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 40);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[104]);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[105]);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[106], true);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[107], true);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[108], true);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[109], true);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[110]).shortValue());
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[111]).shortValue());
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[112], 4);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[113], 4);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 40);
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 40);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[116]).intValue());
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[117]).intValue());
               }
               return;
      }
   }

}

