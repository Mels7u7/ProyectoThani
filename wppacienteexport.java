package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wppacienteexport extends GXProcedure
{
   public wppacienteexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wppacienteexport.class ), "" );
   }

   public wppacienteexport( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      wppacienteexport.this.aP1 = new String[] {""};
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
      wppacienteexport.this.aP0 = aP0;
      wppacienteexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_SdtWWPContext1[0] = AV9WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV9WWPContext = GXv_SdtWWPContext1[0] ;
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
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'OPENDOCUMENT' Routine */
      returnInSub = false ;
      AV16Random = (int)(GXutil.random( )*10000) ;
      AV12Filename = "WPPacienteExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Filter") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV19FilterFullText, GXv_char5) ;
         wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
      }
      if ( ! ( (0==AV35TFProfesionalId) && (0==AV36TFProfesionalId_To) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Id") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFProfesionalId );
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, false, GXv_int3, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFProfesionalId_To );
      }
      if ( ! ( ( AV38TFProfesionalTipoDocumento_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Tipo Documento") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         AV99i = 1 ;
         AV102GXV1 = 1 ;
         while ( AV102GXV1 <= AV38TFProfesionalTipoDocumento_Sels.size() )
         {
            AV39TFProfesionalTipoDocumento_Sel = (String)AV38TFProfesionalTipoDocumento_Sels.elementAt(-1+AV102GXV1) ;
            if ( AV99i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomaintipodocumento.getDescription(httpContext,(String)AV39TFProfesionalTipoDocumento_Sel) );
            AV99i = (long)(AV99i+1) ;
            AV102GXV1 = (int)(AV102GXV1+1) ;
         }
      }
      if ( ! ( (GXutil.strcmp("", AV41TFProfesionalNroDocumento_Sel)==0) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Nro Documento") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV41TFProfesionalNroDocumento_Sel, GXv_char5) ;
         wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV40TFProfesionalNroDocumento)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Nro Documento") ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFProfesionalNroDocumento, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV43TFProfesionalApellidoPaterno_Sel)==0) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Apellido Paterno") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV43TFProfesionalApellidoPaterno_Sel, GXv_char5) ;
         wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV42TFProfesionalApellidoPaterno)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Apellido Paterno") ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFProfesionalApellidoPaterno, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV45TFProfesionalApellidoMaterno_Sel)==0) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Apellido Materno") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV45TFProfesionalApellidoMaterno_Sel, GXv_char5) ;
         wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV44TFProfesionalApellidoMaterno)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Apellido Materno") ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV44TFProfesionalApellidoMaterno, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV47TFProfesionalNombres_Sel)==0) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Nombres") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV47TFProfesionalNombres_Sel, GXv_char5) ;
         wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV46TFProfesionalNombres)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Nombres") ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV46TFProfesionalNombres, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV49TFProfesionalNombreCompleto2_Sel)==0) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Nombre Completo2") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV49TFProfesionalNombreCompleto2_Sel, GXv_char5) ;
         wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV48TFProfesionalNombreCompleto2)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Nombre Completo2") ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV48TFProfesionalNombreCompleto2, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV50TFProfesionalFechaNacimiento)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV51TFProfesionalFechaNacimiento_To)) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Fecha Nacimiento") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_dtime6 = GXutil.resetTime( AV50TFProfesionalFechaNacimiento );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime6 );
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, false, GXv_int3, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_dtime6 = GXutil.resetTime( AV51TFProfesionalFechaNacimiento_To );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime6 );
      }
      if ( ! ( ( AV53TFProfesionalSexo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Sexo") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         AV99i = 1 ;
         AV103GXV2 = 1 ;
         while ( AV103GXV2 <= AV53TFProfesionalSexo_Sels.size() )
         {
            AV54TFProfesionalSexo_Sel = (String)AV53TFProfesionalSexo_Sels.elementAt(-1+AV103GXV2) ;
            if ( AV99i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomainsexo.getDescription(httpContext,(String)AV54TFProfesionalSexo_Sel) );
            AV99i = (long)(AV99i+1) ;
            AV103GXV2 = (int)(AV103GXV2+1) ;
         }
      }
      if ( ! ( (GXutil.strcmp("", AV56TFProfesionalDescripcion_Sel)==0) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Descripcion") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV56TFProfesionalDescripcion_Sel, GXv_char5) ;
         wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV55TFProfesionalDescripcion)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Descripcion") ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV55TFProfesionalDescripcion, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV58TFProfesionalCorreo_Sel)==0) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Correo") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV58TFProfesionalCorreo_Sel, GXv_char5) ;
         wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV57TFProfesionalCorreo)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Correo") ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV57TFProfesionalCorreo, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV60TFProfesionalCOP_Sel)==0) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "CMP") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV60TFProfesionalCOP_Sel, GXv_char5) ;
         wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV59TFProfesionalCOP)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "CMP") ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV59TFProfesionalCOP, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV62TFProfesionalColorDisponible_Sel)==0) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Color Disponible") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV62TFProfesionalColorDisponible_Sel, GXv_char5) ;
         wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV61TFProfesionalColorDisponible)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Color Disponible") ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV61TFProfesionalColorDisponible, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV64TFProfesionalColorCita_Sel)==0) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Color Cita") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV64TFProfesionalColorCita_Sel, GXv_char5) ;
         wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV63TFProfesionalColorCita)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Color Cita") ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV63TFProfesionalColorCita, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( ( AV66TFProfesionalTiempoCita_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Tiempo Cita") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         AV99i = 1 ;
         AV104GXV3 = 1 ;
         while ( AV104GXV3 <= AV66TFProfesionalTiempoCita_Sels.size() )
         {
            AV67TFProfesionalTiempoCita_Sel = ((Number) AV66TFProfesionalTiempoCita_Sels.elementAt(-1+AV104GXV3)).byteValue() ;
            if ( AV99i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomaintiempocita.getDescription(httpContext,(byte)AV67TFProfesionalTiempoCita_Sel) );
            AV99i = (long)(AV99i+1) ;
            AV104GXV3 = (int)(AV104GXV3+1) ;
         }
      }
      if ( ! ( (GXutil.strcmp("", AV69TFProfesionalDireccion_Sel)==0) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Direccion") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV69TFProfesionalDireccion_Sel, GXv_char5) ;
         wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV68TFProfesionalDireccion)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Direccion") ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV68TFProfesionalDireccion, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( (0==AV70TFPaisId) && (0==AV71TFPaisId_To) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Pais Id") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV70TFPaisId );
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, false, GXv_int3, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV71TFPaisId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV73TFPaisDescripcion_Sel)==0) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Pais Descripcion") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV73TFPaisDescripcion_Sel, GXv_char5) ;
         wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV72TFPaisDescripcion)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Pais Descripcion") ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV72TFPaisDescripcion, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV75TFUbigeoCode_Sel)==0) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Ubigeo Code") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV75TFUbigeoCode_Sel, GXv_char5) ;
         wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV74TFUbigeoCode)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Ubigeo Code") ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV74TFUbigeoCode, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV77TFUbigeoNombre_Sel)==0) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Ubigeo") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV77TFUbigeoNombre_Sel, GXv_char5) ;
         wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV76TFUbigeoNombre)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Ubigeo") ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV76TFUbigeoNombre, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV79TFProfesionalTwitter_Sel)==0) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Twitter") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV79TFProfesionalTwitter_Sel, GXv_char5) ;
         wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV78TFProfesionalTwitter)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Twitter") ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV78TFProfesionalTwitter, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV81TFProfesionalFacebook_Sel)==0) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Facebook") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV81TFProfesionalFacebook_Sel, GXv_char5) ;
         wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV80TFProfesionalFacebook)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Facebook") ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV80TFProfesionalFacebook, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV83TFProfesionalInstagram_Sel)==0) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Instagram") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV83TFProfesionalInstagram_Sel, GXv_char5) ;
         wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV82TFProfesionalInstagram)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Instagram") ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV82TFProfesionalInstagram, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV85TFProfesionalLinkedin_Sel)==0) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Linkedin") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV85TFProfesionalLinkedin_Sel, GXv_char5) ;
         wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV84TFProfesionalLinkedin)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Linkedin") ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV84TFProfesionalLinkedin, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV87TFProfesionalTelefono_Sel)==0) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Telefono") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV87TFProfesionalTelefono_Sel, GXv_char5) ;
         wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV86TFProfesionalTelefono)==0) ) )
         {
            GXv_exceldoc2[0] = AV11ExcelDocument ;
            GXv_int3[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Telefono") ;
            AV11ExcelDocument = GXv_exceldoc2[0] ;
            wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV86TFProfesionalTelefono, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( (0==AV88TFSecUserId) && (0==AV89TFSecUserId_To) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "User Id") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV88TFSecUserId );
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, false, GXv_int3, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV89TFSecUserId_To );
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV90TFProfesionalFechaRegistro)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV91TFProfesionalFechaRegistro_To)) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Fecha Registro") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_dtime6 = GXutil.resetTime( AV90TFProfesionalFechaRegistro );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime6 );
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, false, GXv_int3, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_dtime6 = GXutil.resetTime( AV91TFProfesionalFechaRegistro_To );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime6 );
      }
      if ( ! ( (0==AV92TFProfesionalTerminosCondiciones_Sel) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Terminos Condiciones") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         if ( AV92TFProfesionalTerminosCondiciones_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "Marcado" );
         }
         else if ( AV92TFProfesionalTerminosCondiciones_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "Desmarcado" );
         }
      }
      if ( ! ( ( AV94TFProfesionalEstadoCuenta_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Estado Cuenta") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         AV99i = 1 ;
         AV105GXV4 = 1 ;
         while ( AV105GXV4 <= AV94TFProfesionalEstadoCuenta_Sels.size() )
         {
            AV95TFProfesionalEstadoCuenta_Sel = (String)AV94TFProfesionalEstadoCuenta_Sels.elementAt(-1+AV105GXV4) ;
            if ( AV99i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomainestadocuenta.getDescription(httpContext,(String)AV95TFProfesionalEstadoCuenta_Sel) );
            AV99i = (long)(AV99i+1) ;
            AV105GXV4 = (int)(AV105GXV4+1) ;
         }
      }
      if ( ! ( ( AV97TFProfesionalEstado_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), "Estado") ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         wppacienteexport.this.AV14CellRow = GXv_int3[0] ;
         AV99i = 1 ;
         AV106GXV5 = 1 ;
         while ( AV106GXV5 <= AV97TFProfesionalEstado_Sels.size() )
         {
            AV98TFProfesionalEstado_Sel = (String)AV97TFProfesionalEstado_Sels.elementAt(-1+AV106GXV5) ;
            if ( AV99i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomainestadoprofesional.getDescription(httpContext,(String)AV98TFProfesionalEstado_Sel) );
            AV99i = (long)(AV99i+1) ;
            AV106GXV5 = (int)(AV106GXV5+1) ;
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("WPPacienteColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("WPPacienteColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV107GXV6 = 1 ;
      while ( AV107GXV6 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV107GXV6));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV107GXV6 = (int)(AV107GXV6+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV109Wppacienteds_1_filterfulltext = AV19FilterFullText ;
      AV110Wppacienteds_2_tfprofesionalid = AV35TFProfesionalId ;
      AV111Wppacienteds_3_tfprofesionalid_to = AV36TFProfesionalId_To ;
      AV112Wppacienteds_4_tfprofesionaltipodocumento_sels = AV38TFProfesionalTipoDocumento_Sels ;
      AV113Wppacienteds_5_tfprofesionalnrodocumento = AV40TFProfesionalNroDocumento ;
      AV114Wppacienteds_6_tfprofesionalnrodocumento_sel = AV41TFProfesionalNroDocumento_Sel ;
      AV115Wppacienteds_7_tfprofesionalapellidopaterno = AV42TFProfesionalApellidoPaterno ;
      AV116Wppacienteds_8_tfprofesionalapellidopaterno_sel = AV43TFProfesionalApellidoPaterno_Sel ;
      AV117Wppacienteds_9_tfprofesionalapellidomaterno = AV44TFProfesionalApellidoMaterno ;
      AV118Wppacienteds_10_tfprofesionalapellidomaterno_sel = AV45TFProfesionalApellidoMaterno_Sel ;
      AV119Wppacienteds_11_tfprofesionalnombres = AV46TFProfesionalNombres ;
      AV120Wppacienteds_12_tfprofesionalnombres_sel = AV47TFProfesionalNombres_Sel ;
      AV121Wppacienteds_13_tfprofesionalnombrecompleto2 = AV48TFProfesionalNombreCompleto2 ;
      AV122Wppacienteds_14_tfprofesionalnombrecompleto2_sel = AV49TFProfesionalNombreCompleto2_Sel ;
      AV123Wppacienteds_15_tfprofesionalfechanacimiento = AV50TFProfesionalFechaNacimiento ;
      AV124Wppacienteds_16_tfprofesionalfechanacimiento_to = AV51TFProfesionalFechaNacimiento_To ;
      AV125Wppacienteds_17_tfprofesionalsexo_sels = AV53TFProfesionalSexo_Sels ;
      AV126Wppacienteds_18_tfprofesionaldescripcion = AV55TFProfesionalDescripcion ;
      AV127Wppacienteds_19_tfprofesionaldescripcion_sel = AV56TFProfesionalDescripcion_Sel ;
      AV128Wppacienteds_20_tfprofesionalcorreo = AV57TFProfesionalCorreo ;
      AV129Wppacienteds_21_tfprofesionalcorreo_sel = AV58TFProfesionalCorreo_Sel ;
      AV130Wppacienteds_22_tfprofesionalcop = AV59TFProfesionalCOP ;
      AV131Wppacienteds_23_tfprofesionalcop_sel = AV60TFProfesionalCOP_Sel ;
      AV132Wppacienteds_24_tfprofesionalcolordisponible = AV61TFProfesionalColorDisponible ;
      AV133Wppacienteds_25_tfprofesionalcolordisponible_sel = AV62TFProfesionalColorDisponible_Sel ;
      AV134Wppacienteds_26_tfprofesionalcolorcita = AV63TFProfesionalColorCita ;
      AV135Wppacienteds_27_tfprofesionalcolorcita_sel = AV64TFProfesionalColorCita_Sel ;
      AV136Wppacienteds_28_tfprofesionaltiempocita_sels = AV66TFProfesionalTiempoCita_Sels ;
      AV137Wppacienteds_29_tfprofesionaldireccion = AV68TFProfesionalDireccion ;
      AV138Wppacienteds_30_tfprofesionaldireccion_sel = AV69TFProfesionalDireccion_Sel ;
      AV139Wppacienteds_31_tfpaisid = AV70TFPaisId ;
      AV140Wppacienteds_32_tfpaisid_to = AV71TFPaisId_To ;
      AV141Wppacienteds_33_tfpaisdescripcion = AV72TFPaisDescripcion ;
      AV142Wppacienteds_34_tfpaisdescripcion_sel = AV73TFPaisDescripcion_Sel ;
      AV143Wppacienteds_35_tfubigeocode = AV74TFUbigeoCode ;
      AV144Wppacienteds_36_tfubigeocode_sel = AV75TFUbigeoCode_Sel ;
      AV145Wppacienteds_37_tfubigeonombre = AV76TFUbigeoNombre ;
      AV146Wppacienteds_38_tfubigeonombre_sel = AV77TFUbigeoNombre_Sel ;
      AV147Wppacienteds_39_tfprofesionaltwitter = AV78TFProfesionalTwitter ;
      AV148Wppacienteds_40_tfprofesionaltwitter_sel = AV79TFProfesionalTwitter_Sel ;
      AV149Wppacienteds_41_tfprofesionalfacebook = AV80TFProfesionalFacebook ;
      AV150Wppacienteds_42_tfprofesionalfacebook_sel = AV81TFProfesionalFacebook_Sel ;
      AV151Wppacienteds_43_tfprofesionalinstagram = AV82TFProfesionalInstagram ;
      AV152Wppacienteds_44_tfprofesionalinstagram_sel = AV83TFProfesionalInstagram_Sel ;
      AV153Wppacienteds_45_tfprofesionallinkedin = AV84TFProfesionalLinkedin ;
      AV154Wppacienteds_46_tfprofesionallinkedin_sel = AV85TFProfesionalLinkedin_Sel ;
      AV155Wppacienteds_47_tfprofesionaltelefono = AV86TFProfesionalTelefono ;
      AV156Wppacienteds_48_tfprofesionaltelefono_sel = AV87TFProfesionalTelefono_Sel ;
      AV157Wppacienteds_49_tfsecuserid = AV88TFSecUserId ;
      AV158Wppacienteds_50_tfsecuserid_to = AV89TFSecUserId_To ;
      AV159Wppacienteds_51_tfprofesionalfecharegistro = AV90TFProfesionalFechaRegistro ;
      AV160Wppacienteds_52_tfprofesionalfecharegistro_to = AV91TFProfesionalFechaRegistro_To ;
      AV161Wppacienteds_53_tfprofesionalterminoscondiciones_sel = AV92TFProfesionalTerminosCondiciones_Sel ;
      AV162Wppacienteds_54_tfprofesionalestadocuenta_sels = AV94TFProfesionalEstadoCuenta_Sels ;
      AV163Wppacienteds_55_tfprofesionalestado_sels = AV97TFProfesionalEstado_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A173ProfesionalTipoDocumento ,
                                           AV112Wppacienteds_4_tfprofesionaltipodocumento_sels ,
                                           A177ProfesionalSexo ,
                                           AV125Wppacienteds_17_tfprofesionalsexo_sels ,
                                           Byte.valueOf(A182ProfesionalTiempoCita) ,
                                           AV136Wppacienteds_28_tfprofesionaltiempocita_sels ,
                                           A197ProfesionalEstadoCuenta ,
                                           AV162Wppacienteds_54_tfprofesionalestadocuenta_sels ,
                                           A198ProfesionalEstado ,
                                           AV163Wppacienteds_55_tfprofesionalestado_sels ,
                                           AV109Wppacienteds_1_filterfulltext ,
                                           Integer.valueOf(AV110Wppacienteds_2_tfprofesionalid) ,
                                           Integer.valueOf(AV111Wppacienteds_3_tfprofesionalid_to) ,
                                           Integer.valueOf(AV112Wppacienteds_4_tfprofesionaltipodocumento_sels.size()) ,
                                           AV114Wppacienteds_6_tfprofesionalnrodocumento_sel ,
                                           AV113Wppacienteds_5_tfprofesionalnrodocumento ,
                                           AV116Wppacienteds_8_tfprofesionalapellidopaterno_sel ,
                                           AV115Wppacienteds_7_tfprofesionalapellidopaterno ,
                                           AV118Wppacienteds_10_tfprofesionalapellidomaterno_sel ,
                                           AV117Wppacienteds_9_tfprofesionalapellidomaterno ,
                                           AV120Wppacienteds_12_tfprofesionalnombres_sel ,
                                           AV119Wppacienteds_11_tfprofesionalnombres ,
                                           AV122Wppacienteds_14_tfprofesionalnombrecompleto2_sel ,
                                           AV121Wppacienteds_13_tfprofesionalnombrecompleto2 ,
                                           AV123Wppacienteds_15_tfprofesionalfechanacimiento ,
                                           AV124Wppacienteds_16_tfprofesionalfechanacimiento_to ,
                                           Integer.valueOf(AV125Wppacienteds_17_tfprofesionalsexo_sels.size()) ,
                                           AV127Wppacienteds_19_tfprofesionaldescripcion_sel ,
                                           AV126Wppacienteds_18_tfprofesionaldescripcion ,
                                           AV129Wppacienteds_21_tfprofesionalcorreo_sel ,
                                           AV128Wppacienteds_20_tfprofesionalcorreo ,
                                           AV131Wppacienteds_23_tfprofesionalcop_sel ,
                                           AV130Wppacienteds_22_tfprofesionalcop ,
                                           AV133Wppacienteds_25_tfprofesionalcolordisponible_sel ,
                                           AV132Wppacienteds_24_tfprofesionalcolordisponible ,
                                           AV135Wppacienteds_27_tfprofesionalcolorcita_sel ,
                                           AV134Wppacienteds_26_tfprofesionalcolorcita ,
                                           Integer.valueOf(AV136Wppacienteds_28_tfprofesionaltiempocita_sels.size()) ,
                                           AV138Wppacienteds_30_tfprofesionaldireccion_sel ,
                                           AV137Wppacienteds_29_tfprofesionaldireccion ,
                                           Short.valueOf(AV139Wppacienteds_31_tfpaisid) ,
                                           Short.valueOf(AV140Wppacienteds_32_tfpaisid_to) ,
                                           AV142Wppacienteds_34_tfpaisdescripcion_sel ,
                                           AV141Wppacienteds_33_tfpaisdescripcion ,
                                           AV144Wppacienteds_36_tfubigeocode_sel ,
                                           AV143Wppacienteds_35_tfubigeocode ,
                                           AV146Wppacienteds_38_tfubigeonombre_sel ,
                                           AV145Wppacienteds_37_tfubigeonombre ,
                                           AV148Wppacienteds_40_tfprofesionaltwitter_sel ,
                                           AV147Wppacienteds_39_tfprofesionaltwitter ,
                                           AV150Wppacienteds_42_tfprofesionalfacebook_sel ,
                                           AV149Wppacienteds_41_tfprofesionalfacebook ,
                                           AV152Wppacienteds_44_tfprofesionalinstagram_sel ,
                                           AV151Wppacienteds_43_tfprofesionalinstagram ,
                                           AV154Wppacienteds_46_tfprofesionallinkedin_sel ,
                                           AV153Wppacienteds_45_tfprofesionallinkedin ,
                                           AV156Wppacienteds_48_tfprofesionaltelefono_sel ,
                                           AV155Wppacienteds_47_tfprofesionaltelefono ,
                                           Short.valueOf(AV157Wppacienteds_49_tfsecuserid) ,
                                           Short.valueOf(AV158Wppacienteds_50_tfsecuserid_to) ,
                                           AV159Wppacienteds_51_tfprofesionalfecharegistro ,
                                           AV160Wppacienteds_52_tfprofesionalfecharegistro_to ,
                                           Byte.valueOf(AV161Wppacienteds_53_tfprofesionalterminoscondiciones_sel) ,
                                           Integer.valueOf(AV162Wppacienteds_54_tfprofesionalestadocuenta_sels.size()) ,
                                           Integer.valueOf(AV163Wppacienteds_55_tfprofesionalestado_sels.size()) ,
                                           Integer.valueOf(A31ProfesionalId) ,
                                           A174ProfesionalNroDocumento ,
                                           A85ProfesionalApellidoPaterno ,
                                           A86ProfesionalApellidoMaterno ,
                                           A84ProfesionalNombres ,
                                           A178ProfesionalDescripcion ,
                                           A179ProfesionalCorreo ,
                                           A88ProfesionalCOP ,
                                           A180ProfesionalColorDisponible ,
                                           A181ProfesionalColorCita ,
                                           A183ProfesionalDireccion ,
                                           Short.valueOf(A43PaisId) ,
                                           A184PaisDescripcion ,
                                           A44UbigeoCode ,
                                           A186UbigeoDepartamento ,
                                           A187UbigeoProvincia ,
                                           A188UbigeoDistrito ,
                                           A190ProfesionalTwitter ,
                                           A191ProfesionalFacebook ,
                                           A192ProfesionalInstagram ,
                                           A193ProfesionalLinkedin ,
                                           A194ProfesionalTelefono ,
                                           Short.valueOf(A6SecUserId) ,
                                           A176ProfesionalFechaNacimiento ,
                                           A195ProfesionalFechaRegistro ,
                                           Boolean.valueOf(A196ProfesionalTerminosCondiciones) ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV109Wppacienteds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV109Wppacienteds_1_filterfulltext), "%", "") ;
      lV113Wppacienteds_5_tfprofesionalnrodocumento = GXutil.concat( GXutil.rtrim( AV113Wppacienteds_5_tfprofesionalnrodocumento), "%", "") ;
      lV115Wppacienteds_7_tfprofesionalapellidopaterno = GXutil.concat( GXutil.rtrim( AV115Wppacienteds_7_tfprofesionalapellidopaterno), "%", "") ;
      lV117Wppacienteds_9_tfprofesionalapellidomaterno = GXutil.concat( GXutil.rtrim( AV117Wppacienteds_9_tfprofesionalapellidomaterno), "%", "") ;
      lV119Wppacienteds_11_tfprofesionalnombres = GXutil.concat( GXutil.rtrim( AV119Wppacienteds_11_tfprofesionalnombres), "%", "") ;
      lV121Wppacienteds_13_tfprofesionalnombrecompleto2 = GXutil.concat( GXutil.rtrim( AV121Wppacienteds_13_tfprofesionalnombrecompleto2), "%", "") ;
      lV126Wppacienteds_18_tfprofesionaldescripcion = GXutil.concat( GXutil.rtrim( AV126Wppacienteds_18_tfprofesionaldescripcion), "%", "") ;
      lV128Wppacienteds_20_tfprofesionalcorreo = GXutil.concat( GXutil.rtrim( AV128Wppacienteds_20_tfprofesionalcorreo), "%", "") ;
      lV130Wppacienteds_22_tfprofesionalcop = GXutil.concat( GXutil.rtrim( AV130Wppacienteds_22_tfprofesionalcop), "%", "") ;
      lV132Wppacienteds_24_tfprofesionalcolordisponible = GXutil.padr( GXutil.rtrim( AV132Wppacienteds_24_tfprofesionalcolordisponible), 20, "%") ;
      lV134Wppacienteds_26_tfprofesionalcolorcita = GXutil.padr( GXutil.rtrim( AV134Wppacienteds_26_tfprofesionalcolorcita), 20, "%") ;
      lV137Wppacienteds_29_tfprofesionaldireccion = GXutil.concat( GXutil.rtrim( AV137Wppacienteds_29_tfprofesionaldireccion), "%", "") ;
      lV141Wppacienteds_33_tfpaisdescripcion = GXutil.concat( GXutil.rtrim( AV141Wppacienteds_33_tfpaisdescripcion), "%", "") ;
      lV143Wppacienteds_35_tfubigeocode = GXutil.padr( GXutil.rtrim( AV143Wppacienteds_35_tfubigeocode), 10, "%") ;
      lV145Wppacienteds_37_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV145Wppacienteds_37_tfubigeonombre), "%", "") ;
      lV147Wppacienteds_39_tfprofesionaltwitter = GXutil.concat( GXutil.rtrim( AV147Wppacienteds_39_tfprofesionaltwitter), "%", "") ;
      lV149Wppacienteds_41_tfprofesionalfacebook = GXutil.concat( GXutil.rtrim( AV149Wppacienteds_41_tfprofesionalfacebook), "%", "") ;
      lV151Wppacienteds_43_tfprofesionalinstagram = GXutil.concat( GXutil.rtrim( AV151Wppacienteds_43_tfprofesionalinstagram), "%", "") ;
      lV153Wppacienteds_45_tfprofesionallinkedin = GXutil.concat( GXutil.rtrim( AV153Wppacienteds_45_tfprofesionallinkedin), "%", "") ;
      lV155Wppacienteds_47_tfprofesionaltelefono = GXutil.padr( GXutil.rtrim( AV155Wppacienteds_47_tfprofesionaltelefono), 20, "%") ;
      /* Using cursor P007U2 */
      pr_default.execute(0, new Object[] {lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, lV109Wppacienteds_1_filterfulltext, Integer.valueOf(AV110Wppacienteds_2_tfprofesionalid), Integer.valueOf(AV111Wppacienteds_3_tfprofesionalid_to), lV113Wppacienteds_5_tfprofesionalnrodocumento, AV114Wppacienteds_6_tfprofesionalnrodocumento_sel, lV115Wppacienteds_7_tfprofesionalapellidopaterno, AV116Wppacienteds_8_tfprofesionalapellidopaterno_sel, lV117Wppacienteds_9_tfprofesionalapellidomaterno, AV118Wppacienteds_10_tfprofesionalapellidomaterno_sel, lV119Wppacienteds_11_tfprofesionalnombres, AV120Wppacienteds_12_tfprofesionalnombres_sel, lV121Wppacienteds_13_tfprofesionalnombrecompleto2, AV122Wppacienteds_14_tfprofesionalnombrecompleto2_sel, AV123Wppacienteds_15_tfprofesionalfechanacimiento, AV124Wppacienteds_16_tfprofesionalfechanacimiento_to, lV126Wppacienteds_18_tfprofesionaldescripcion, AV127Wppacienteds_19_tfprofesionaldescripcion_sel, lV128Wppacienteds_20_tfprofesionalcorreo, AV129Wppacienteds_21_tfprofesionalcorreo_sel, lV130Wppacienteds_22_tfprofesionalcop, AV131Wppacienteds_23_tfprofesionalcop_sel, lV132Wppacienteds_24_tfprofesionalcolordisponible, AV133Wppacienteds_25_tfprofesionalcolordisponible_sel, lV134Wppacienteds_26_tfprofesionalcolorcita, AV135Wppacienteds_27_tfprofesionalcolorcita_sel, lV137Wppacienteds_29_tfprofesionaldireccion, AV138Wppacienteds_30_tfprofesionaldireccion_sel, Short.valueOf(AV139Wppacienteds_31_tfpaisid), Short.valueOf(AV140Wppacienteds_32_tfpaisid_to), lV141Wppacienteds_33_tfpaisdescripcion, AV142Wppacienteds_34_tfpaisdescripcion_sel, lV143Wppacienteds_35_tfubigeocode, AV144Wppacienteds_36_tfubigeocode_sel, lV145Wppacienteds_37_tfubigeonombre, AV146Wppacienteds_38_tfubigeonombre_sel, lV147Wppacienteds_39_tfprofesionaltwitter, AV148Wppacienteds_40_tfprofesionaltwitter_sel, lV149Wppacienteds_41_tfprofesionalfacebook, AV150Wppacienteds_42_tfprofesionalfacebook_sel, lV151Wppacienteds_43_tfprofesionalinstagram, AV152Wppacienteds_44_tfprofesionalinstagram_sel, lV153Wppacienteds_45_tfprofesionallinkedin, AV154Wppacienteds_46_tfprofesionallinkedin_sel, lV155Wppacienteds_47_tfprofesionaltelefono, AV156Wppacienteds_48_tfprofesionaltelefono_sel, Short.valueOf(AV157Wppacienteds_49_tfsecuserid), Short.valueOf(AV158Wppacienteds_50_tfsecuserid_to), AV159Wppacienteds_51_tfprofesionalfecharegistro, AV160Wppacienteds_52_tfprofesionalfecharegistro_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A196ProfesionalTerminosCondiciones = P007U2_A196ProfesionalTerminosCondiciones[0] ;
         A195ProfesionalFechaRegistro = P007U2_A195ProfesionalFechaRegistro[0] ;
         A6SecUserId = P007U2_A6SecUserId[0] ;
         A43PaisId = P007U2_A43PaisId[0] ;
         A176ProfesionalFechaNacimiento = P007U2_A176ProfesionalFechaNacimiento[0] ;
         A31ProfesionalId = P007U2_A31ProfesionalId[0] ;
         A198ProfesionalEstado = P007U2_A198ProfesionalEstado[0] ;
         A197ProfesionalEstadoCuenta = P007U2_A197ProfesionalEstadoCuenta[0] ;
         A194ProfesionalTelefono = P007U2_A194ProfesionalTelefono[0] ;
         A193ProfesionalLinkedin = P007U2_A193ProfesionalLinkedin[0] ;
         A192ProfesionalInstagram = P007U2_A192ProfesionalInstagram[0] ;
         A191ProfesionalFacebook = P007U2_A191ProfesionalFacebook[0] ;
         A190ProfesionalTwitter = P007U2_A190ProfesionalTwitter[0] ;
         A44UbigeoCode = P007U2_A44UbigeoCode[0] ;
         A184PaisDescripcion = P007U2_A184PaisDescripcion[0] ;
         A183ProfesionalDireccion = P007U2_A183ProfesionalDireccion[0] ;
         A182ProfesionalTiempoCita = P007U2_A182ProfesionalTiempoCita[0] ;
         A181ProfesionalColorCita = P007U2_A181ProfesionalColorCita[0] ;
         A180ProfesionalColorDisponible = P007U2_A180ProfesionalColorDisponible[0] ;
         A88ProfesionalCOP = P007U2_A88ProfesionalCOP[0] ;
         A179ProfesionalCorreo = P007U2_A179ProfesionalCorreo[0] ;
         A178ProfesionalDescripcion = P007U2_A178ProfesionalDescripcion[0] ;
         A177ProfesionalSexo = P007U2_A177ProfesionalSexo[0] ;
         A174ProfesionalNroDocumento = P007U2_A174ProfesionalNroDocumento[0] ;
         A173ProfesionalTipoDocumento = P007U2_A173ProfesionalTipoDocumento[0] ;
         A84ProfesionalNombres = P007U2_A84ProfesionalNombres[0] ;
         A86ProfesionalApellidoMaterno = P007U2_A86ProfesionalApellidoMaterno[0] ;
         A85ProfesionalApellidoPaterno = P007U2_A85ProfesionalApellidoPaterno[0] ;
         A188UbigeoDistrito = P007U2_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P007U2_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P007U2_A186UbigeoDepartamento[0] ;
         A184PaisDescripcion = P007U2_A184PaisDescripcion[0] ;
         A188UbigeoDistrito = P007U2_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P007U2_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P007U2_A186UbigeoDepartamento[0] ;
         A175ProfesionalNombreCompleto2 = A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno + ", " + A84ProfesionalNombres ;
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
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
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A31ProfesionalId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomaintipodocumento.getDescription(httpContext,(String)A173ProfesionalTipoDocumento) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A174ProfesionalNroDocumento, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char4 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A85ProfesionalApellidoPaterno, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char4 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A86ProfesionalApellidoMaterno, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char4 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A84ProfesionalNombres, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char4 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A175ProfesionalNombreCompleto2, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char4 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_dtime6 = GXutil.resetTime( A176ProfesionalFechaNacimiento );
            AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setDate( GXt_dtime6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomainsexo.getDescription(httpContext,(String)A177ProfesionalSexo) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A178ProfesionalDescripcion, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char4 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A179ProfesionalCorreo, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char4 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A88ProfesionalCOP, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char4 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A180ProfesionalColorDisponible, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char4 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A181ProfesionalColorCita, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char4 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomaintiempocita.getDescription(httpContext,(byte)A182ProfesionalTiempoCita) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+16)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A183ProfesionalDireccion, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char4 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+17)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A43PaisId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+18)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A184PaisDescripcion, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char4 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+19)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A44UbigeoCode, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char4 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+20)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A185UbigeoNombre, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char4 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+21)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( "" );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+22)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A190ProfesionalTwitter, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char4 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+23)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A191ProfesionalFacebook, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char4 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+24)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A192ProfesionalInstagram, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char4 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+25)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A193ProfesionalLinkedin, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char4 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+26)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A194ProfesionalTelefono, GXv_char5) ;
            wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char4 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+27)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A6SecUserId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+28)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_dtime6 = GXutil.resetTime( A195ProfesionalFechaRegistro );
            AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setDate( GXt_dtime6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+29)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A196ProfesionalTerminosCondiciones) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+30)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomainestadocuenta.getDescription(httpContext,(String)A197ProfesionalEstadoCuenta) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+31)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomainestadoprofesional.getDescription(httpContext,(String)A198ProfesionalEstado) );
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
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ProfesionalId", "", "Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ProfesionalTipoDocumento", "", "Tipo Documento", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ProfesionalNroDocumento", "", "Nro Documento", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ProfesionalApellidoPaterno", "", "Apellido Paterno", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ProfesionalApellidoMaterno", "", "Apellido Materno", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ProfesionalNombres", "", "Nombres", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ProfesionalNombreCompleto2", "", "Nombre Completo2", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ProfesionalFechaNacimiento", "", "Fecha Nacimiento", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ProfesionalSexo", "", "Sexo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ProfesionalDescripcion", "", "Descripcion", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ProfesionalCorreo", "", "Correo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ProfesionalCOP", "", "CMP", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ProfesionalColorDisponible", "", "Color Disponible", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ProfesionalColorCita", "", "Color Cita", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ProfesionalTiempoCita", "", "Tiempo Cita", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ProfesionalDireccion", "", "Direccion", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "PaisId", "", "Pais Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "PaisDescripcion", "", "Pais Descripcion", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "UbigeoCode", "", "Ubigeo Code", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "UbigeoNombre", "", "Ubigeo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ProfesionalFoto", "", "Foto", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ProfesionalTwitter", "", "Twitter", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ProfesionalFacebook", "", "Facebook", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ProfesionalInstagram", "", "Instagram", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ProfesionalLinkedin", "", "Linkedin", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ProfesionalTelefono", "", "Telefono", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "SecUserId", "", "User Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ProfesionalFechaRegistro", "", "Fecha Registro", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ProfesionalTerminosCondiciones", "", "Terminos Condiciones", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ProfesionalEstadoCuenta", "", "Estado Cuenta", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXv_SdtWWPColumnsSelector7[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, "ProfesionalEstado", "", "Estado", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector7[0] ;
      GXt_char4 = AV28UserCustomValue ;
      GXv_char5[0] = GXt_char4 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "WPPacienteColumnsSelector", GXv_char5) ;
      wppacienteexport.this.GXt_char4 = GXv_char5[0] ;
      AV28UserCustomValue = GXt_char4 ;
      if ( ! ( (GXutil.strcmp("", AV28UserCustomValue)==0) ) )
      {
         AV25ColumnsSelectorAux.fromxml(AV28UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector7[0] = AV25ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
         new com.projectthani.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector7, GXv_SdtWWPColumnsSelector8) ;
         AV25ColumnsSelectorAux = GXv_SdtWWPColumnsSelector7[0] ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("WPPacienteGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "WPPacienteGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("WPPacienteGridState"), null, null);
      }
      AV17OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV18OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV164GXV7 = 1 ;
      while ( AV164GXV7 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV164GXV7));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV19FilterFullText = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALID") == 0 )
         {
            AV35TFProfesionalId = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFProfesionalId_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALTIPODOCUMENTO_SEL") == 0 )
         {
            AV37TFProfesionalTipoDocumento_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV38TFProfesionalTipoDocumento_Sels.fromJSonString(AV37TFProfesionalTipoDocumento_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNRODOCUMENTO") == 0 )
         {
            AV40TFProfesionalNroDocumento = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNRODOCUMENTO_SEL") == 0 )
         {
            AV41TFProfesionalNroDocumento_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALAPELLIDOPATERNO") == 0 )
         {
            AV42TFProfesionalApellidoPaterno = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALAPELLIDOPATERNO_SEL") == 0 )
         {
            AV43TFProfesionalApellidoPaterno_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALAPELLIDOMATERNO") == 0 )
         {
            AV44TFProfesionalApellidoMaterno = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALAPELLIDOMATERNO_SEL") == 0 )
         {
            AV45TFProfesionalApellidoMaterno_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNOMBRES") == 0 )
         {
            AV46TFProfesionalNombres = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNOMBRES_SEL") == 0 )
         {
            AV47TFProfesionalNombres_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNOMBRECOMPLETO2") == 0 )
         {
            AV48TFProfesionalNombreCompleto2 = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNOMBRECOMPLETO2_SEL") == 0 )
         {
            AV49TFProfesionalNombreCompleto2_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALFECHANACIMIENTO") == 0 )
         {
            AV50TFProfesionalFechaNacimiento = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            AV51TFProfesionalFechaNacimiento_To = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALSEXO_SEL") == 0 )
         {
            AV52TFProfesionalSexo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV53TFProfesionalSexo_Sels.fromJSonString(AV52TFProfesionalSexo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALDESCRIPCION") == 0 )
         {
            AV55TFProfesionalDescripcion = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALDESCRIPCION_SEL") == 0 )
         {
            AV56TFProfesionalDescripcion_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCORREO") == 0 )
         {
            AV57TFProfesionalCorreo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCORREO_SEL") == 0 )
         {
            AV58TFProfesionalCorreo_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCOP") == 0 )
         {
            AV59TFProfesionalCOP = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCOP_SEL") == 0 )
         {
            AV60TFProfesionalCOP_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCOLORDISPONIBLE") == 0 )
         {
            AV61TFProfesionalColorDisponible = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCOLORDISPONIBLE_SEL") == 0 )
         {
            AV62TFProfesionalColorDisponible_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCOLORCITA") == 0 )
         {
            AV63TFProfesionalColorCita = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCOLORCITA_SEL") == 0 )
         {
            AV64TFProfesionalColorCita_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALTIEMPOCITA_SEL") == 0 )
         {
            AV65TFProfesionalTiempoCita_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV66TFProfesionalTiempoCita_Sels.fromJSonString(AV65TFProfesionalTiempoCita_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALDIRECCION") == 0 )
         {
            AV68TFProfesionalDireccion = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALDIRECCION_SEL") == 0 )
         {
            AV69TFProfesionalDireccion_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAISID") == 0 )
         {
            AV70TFPaisId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV71TFPaisId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAISDESCRIPCION") == 0 )
         {
            AV72TFPaisDescripcion = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAISDESCRIPCION_SEL") == 0 )
         {
            AV73TFPaisDescripcion_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE") == 0 )
         {
            AV74TFUbigeoCode = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE_SEL") == 0 )
         {
            AV75TFUbigeoCode_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE") == 0 )
         {
            AV76TFUbigeoNombre = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE_SEL") == 0 )
         {
            AV77TFUbigeoNombre_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALTWITTER") == 0 )
         {
            AV78TFProfesionalTwitter = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALTWITTER_SEL") == 0 )
         {
            AV79TFProfesionalTwitter_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALFACEBOOK") == 0 )
         {
            AV80TFProfesionalFacebook = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALFACEBOOK_SEL") == 0 )
         {
            AV81TFProfesionalFacebook_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALINSTAGRAM") == 0 )
         {
            AV82TFProfesionalInstagram = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALINSTAGRAM_SEL") == 0 )
         {
            AV83TFProfesionalInstagram_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALLINKEDIN") == 0 )
         {
            AV84TFProfesionalLinkedin = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALLINKEDIN_SEL") == 0 )
         {
            AV85TFProfesionalLinkedin_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALTELEFONO") == 0 )
         {
            AV86TFProfesionalTelefono = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALTELEFONO_SEL") == 0 )
         {
            AV87TFProfesionalTelefono_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERID") == 0 )
         {
            AV88TFSecUserId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV89TFSecUserId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALFECHAREGISTRO") == 0 )
         {
            AV90TFProfesionalFechaRegistro = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            AV91TFProfesionalFechaRegistro_To = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALTERMINOSCONDICIONES_SEL") == 0 )
         {
            AV92TFProfesionalTerminosCondiciones_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALESTADOCUENTA_SEL") == 0 )
         {
            AV93TFProfesionalEstadoCuenta_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV94TFProfesionalEstadoCuenta_Sels.fromJSonString(AV93TFProfesionalEstadoCuenta_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALESTADO_SEL") == 0 )
         {
            AV96TFProfesionalEstado_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV97TFProfesionalEstado_Sels.fromJSonString(AV96TFProfesionalEstado_SelsJson, null);
         }
         AV164GXV7 = (int)(AV164GXV7+1) ;
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
      this.aP0[0] = wppacienteexport.this.AV12Filename;
      this.aP1[0] = wppacienteexport.this.AV13ErrorMessage;
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
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV19FilterFullText = "" ;
      AV38TFProfesionalTipoDocumento_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39TFProfesionalTipoDocumento_Sel = "" ;
      AV41TFProfesionalNroDocumento_Sel = "" ;
      AV40TFProfesionalNroDocumento = "" ;
      AV43TFProfesionalApellidoPaterno_Sel = "" ;
      AV42TFProfesionalApellidoPaterno = "" ;
      AV45TFProfesionalApellidoMaterno_Sel = "" ;
      AV44TFProfesionalApellidoMaterno = "" ;
      AV47TFProfesionalNombres_Sel = "" ;
      AV46TFProfesionalNombres = "" ;
      AV49TFProfesionalNombreCompleto2_Sel = "" ;
      AV48TFProfesionalNombreCompleto2 = "" ;
      AV50TFProfesionalFechaNacimiento = GXutil.nullDate() ;
      AV51TFProfesionalFechaNacimiento_To = GXutil.nullDate() ;
      AV53TFProfesionalSexo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV54TFProfesionalSexo_Sel = "" ;
      AV56TFProfesionalDescripcion_Sel = "" ;
      AV55TFProfesionalDescripcion = "" ;
      AV58TFProfesionalCorreo_Sel = "" ;
      AV57TFProfesionalCorreo = "" ;
      AV60TFProfesionalCOP_Sel = "" ;
      AV59TFProfesionalCOP = "" ;
      AV62TFProfesionalColorDisponible_Sel = "" ;
      AV61TFProfesionalColorDisponible = "" ;
      AV64TFProfesionalColorCita_Sel = "" ;
      AV63TFProfesionalColorCita = "" ;
      AV66TFProfesionalTiempoCita_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV67TFProfesionalTiempoCita_Sel = (byte)(30) ;
      AV69TFProfesionalDireccion_Sel = "" ;
      AV68TFProfesionalDireccion = "" ;
      AV73TFPaisDescripcion_Sel = "" ;
      AV72TFPaisDescripcion = "" ;
      AV75TFUbigeoCode_Sel = "" ;
      AV74TFUbigeoCode = "" ;
      AV77TFUbigeoNombre_Sel = "" ;
      AV76TFUbigeoNombre = "" ;
      AV79TFProfesionalTwitter_Sel = "" ;
      AV78TFProfesionalTwitter = "" ;
      AV81TFProfesionalFacebook_Sel = "" ;
      AV80TFProfesionalFacebook = "" ;
      AV83TFProfesionalInstagram_Sel = "" ;
      AV82TFProfesionalInstagram = "" ;
      AV85TFProfesionalLinkedin_Sel = "" ;
      AV84TFProfesionalLinkedin = "" ;
      AV87TFProfesionalTelefono_Sel = "" ;
      AV86TFProfesionalTelefono = "" ;
      AV90TFProfesionalFechaRegistro = GXutil.nullDate() ;
      AV91TFProfesionalFechaRegistro_To = GXutil.nullDate() ;
      AV94TFProfesionalEstadoCuenta_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV95TFProfesionalEstadoCuenta_Sel = "" ;
      AV97TFProfesionalEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_exceldoc2 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int3 = new short[1] ;
      AV98TFProfesionalEstado_Sel = "" ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A173ProfesionalTipoDocumento = "" ;
      A174ProfesionalNroDocumento = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      A84ProfesionalNombres = "" ;
      A175ProfesionalNombreCompleto2 = "" ;
      A176ProfesionalFechaNacimiento = GXutil.nullDate() ;
      A177ProfesionalSexo = "" ;
      A178ProfesionalDescripcion = "" ;
      A179ProfesionalCorreo = "" ;
      A88ProfesionalCOP = "" ;
      A180ProfesionalColorDisponible = "" ;
      A181ProfesionalColorCita = "" ;
      A183ProfesionalDireccion = "" ;
      A184PaisDescripcion = "" ;
      A44UbigeoCode = "" ;
      A185UbigeoNombre = "" ;
      A190ProfesionalTwitter = "" ;
      A191ProfesionalFacebook = "" ;
      A192ProfesionalInstagram = "" ;
      A193ProfesionalLinkedin = "" ;
      A194ProfesionalTelefono = "" ;
      A195ProfesionalFechaRegistro = GXutil.nullDate() ;
      A197ProfesionalEstadoCuenta = "" ;
      A198ProfesionalEstado = "" ;
      AV109Wppacienteds_1_filterfulltext = "" ;
      AV112Wppacienteds_4_tfprofesionaltipodocumento_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV113Wppacienteds_5_tfprofesionalnrodocumento = "" ;
      AV114Wppacienteds_6_tfprofesionalnrodocumento_sel = "" ;
      AV115Wppacienteds_7_tfprofesionalapellidopaterno = "" ;
      AV116Wppacienteds_8_tfprofesionalapellidopaterno_sel = "" ;
      AV117Wppacienteds_9_tfprofesionalapellidomaterno = "" ;
      AV118Wppacienteds_10_tfprofesionalapellidomaterno_sel = "" ;
      AV119Wppacienteds_11_tfprofesionalnombres = "" ;
      AV120Wppacienteds_12_tfprofesionalnombres_sel = "" ;
      AV121Wppacienteds_13_tfprofesionalnombrecompleto2 = "" ;
      AV122Wppacienteds_14_tfprofesionalnombrecompleto2_sel = "" ;
      AV123Wppacienteds_15_tfprofesionalfechanacimiento = GXutil.nullDate() ;
      AV124Wppacienteds_16_tfprofesionalfechanacimiento_to = GXutil.nullDate() ;
      AV125Wppacienteds_17_tfprofesionalsexo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV126Wppacienteds_18_tfprofesionaldescripcion = "" ;
      AV127Wppacienteds_19_tfprofesionaldescripcion_sel = "" ;
      AV128Wppacienteds_20_tfprofesionalcorreo = "" ;
      AV129Wppacienteds_21_tfprofesionalcorreo_sel = "" ;
      AV130Wppacienteds_22_tfprofesionalcop = "" ;
      AV131Wppacienteds_23_tfprofesionalcop_sel = "" ;
      AV132Wppacienteds_24_tfprofesionalcolordisponible = "" ;
      AV133Wppacienteds_25_tfprofesionalcolordisponible_sel = "" ;
      AV134Wppacienteds_26_tfprofesionalcolorcita = "" ;
      AV135Wppacienteds_27_tfprofesionalcolorcita_sel = "" ;
      AV136Wppacienteds_28_tfprofesionaltiempocita_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV137Wppacienteds_29_tfprofesionaldireccion = "" ;
      AV138Wppacienteds_30_tfprofesionaldireccion_sel = "" ;
      AV141Wppacienteds_33_tfpaisdescripcion = "" ;
      AV142Wppacienteds_34_tfpaisdescripcion_sel = "" ;
      AV143Wppacienteds_35_tfubigeocode = "" ;
      AV144Wppacienteds_36_tfubigeocode_sel = "" ;
      AV145Wppacienteds_37_tfubigeonombre = "" ;
      AV146Wppacienteds_38_tfubigeonombre_sel = "" ;
      AV147Wppacienteds_39_tfprofesionaltwitter = "" ;
      AV148Wppacienteds_40_tfprofesionaltwitter_sel = "" ;
      AV149Wppacienteds_41_tfprofesionalfacebook = "" ;
      AV150Wppacienteds_42_tfprofesionalfacebook_sel = "" ;
      AV151Wppacienteds_43_tfprofesionalinstagram = "" ;
      AV152Wppacienteds_44_tfprofesionalinstagram_sel = "" ;
      AV153Wppacienteds_45_tfprofesionallinkedin = "" ;
      AV154Wppacienteds_46_tfprofesionallinkedin_sel = "" ;
      AV155Wppacienteds_47_tfprofesionaltelefono = "" ;
      AV156Wppacienteds_48_tfprofesionaltelefono_sel = "" ;
      AV159Wppacienteds_51_tfprofesionalfecharegistro = GXutil.nullDate() ;
      AV160Wppacienteds_52_tfprofesionalfecharegistro_to = GXutil.nullDate() ;
      AV162Wppacienteds_54_tfprofesionalestadocuenta_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV163Wppacienteds_55_tfprofesionalestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV109Wppacienteds_1_filterfulltext = "" ;
      lV113Wppacienteds_5_tfprofesionalnrodocumento = "" ;
      lV115Wppacienteds_7_tfprofesionalapellidopaterno = "" ;
      lV117Wppacienteds_9_tfprofesionalapellidomaterno = "" ;
      lV119Wppacienteds_11_tfprofesionalnombres = "" ;
      lV121Wppacienteds_13_tfprofesionalnombrecompleto2 = "" ;
      lV126Wppacienteds_18_tfprofesionaldescripcion = "" ;
      lV128Wppacienteds_20_tfprofesionalcorreo = "" ;
      lV130Wppacienteds_22_tfprofesionalcop = "" ;
      lV132Wppacienteds_24_tfprofesionalcolordisponible = "" ;
      lV134Wppacienteds_26_tfprofesionalcolorcita = "" ;
      lV137Wppacienteds_29_tfprofesionaldireccion = "" ;
      lV141Wppacienteds_33_tfpaisdescripcion = "" ;
      lV143Wppacienteds_35_tfubigeocode = "" ;
      lV145Wppacienteds_37_tfubigeonombre = "" ;
      lV147Wppacienteds_39_tfprofesionaltwitter = "" ;
      lV149Wppacienteds_41_tfprofesionalfacebook = "" ;
      lV151Wppacienteds_43_tfprofesionalinstagram = "" ;
      lV153Wppacienteds_45_tfprofesionallinkedin = "" ;
      lV155Wppacienteds_47_tfprofesionaltelefono = "" ;
      A186UbigeoDepartamento = "" ;
      A187UbigeoProvincia = "" ;
      A188UbigeoDistrito = "" ;
      P007U2_A196ProfesionalTerminosCondiciones = new boolean[] {false} ;
      P007U2_A195ProfesionalFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      P007U2_A6SecUserId = new short[1] ;
      P007U2_A43PaisId = new short[1] ;
      P007U2_A176ProfesionalFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      P007U2_A31ProfesionalId = new int[1] ;
      P007U2_A198ProfesionalEstado = new String[] {""} ;
      P007U2_A197ProfesionalEstadoCuenta = new String[] {""} ;
      P007U2_A194ProfesionalTelefono = new String[] {""} ;
      P007U2_A193ProfesionalLinkedin = new String[] {""} ;
      P007U2_A192ProfesionalInstagram = new String[] {""} ;
      P007U2_A191ProfesionalFacebook = new String[] {""} ;
      P007U2_A190ProfesionalTwitter = new String[] {""} ;
      P007U2_A44UbigeoCode = new String[] {""} ;
      P007U2_A184PaisDescripcion = new String[] {""} ;
      P007U2_A183ProfesionalDireccion = new String[] {""} ;
      P007U2_A182ProfesionalTiempoCita = new byte[1] ;
      P007U2_A181ProfesionalColorCita = new String[] {""} ;
      P007U2_A180ProfesionalColorDisponible = new String[] {""} ;
      P007U2_A88ProfesionalCOP = new String[] {""} ;
      P007U2_A179ProfesionalCorreo = new String[] {""} ;
      P007U2_A178ProfesionalDescripcion = new String[] {""} ;
      P007U2_A177ProfesionalSexo = new String[] {""} ;
      P007U2_A174ProfesionalNroDocumento = new String[] {""} ;
      P007U2_A173ProfesionalTipoDocumento = new String[] {""} ;
      P007U2_A84ProfesionalNombres = new String[] {""} ;
      P007U2_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P007U2_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P007U2_A188UbigeoDistrito = new String[] {""} ;
      P007U2_A187UbigeoProvincia = new String[] {""} ;
      P007U2_A186UbigeoDepartamento = new String[] {""} ;
      GXt_dtime6 = GXutil.resetTime( GXutil.nullDate() );
      AV28UserCustomValue = "" ;
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      AV25ColumnsSelectorAux = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector7 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector8 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV37TFProfesionalTipoDocumento_SelsJson = "" ;
      AV52TFProfesionalSexo_SelsJson = "" ;
      AV65TFProfesionalTiempoCita_SelsJson = "" ;
      AV93TFProfesionalEstadoCuenta_SelsJson = "" ;
      AV96TFProfesionalEstado_SelsJson = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wppacienteexport__default(),
         new Object[] {
             new Object[] {
            P007U2_A196ProfesionalTerminosCondiciones, P007U2_A195ProfesionalFechaRegistro, P007U2_A6SecUserId, P007U2_A43PaisId, P007U2_A176ProfesionalFechaNacimiento, P007U2_A31ProfesionalId, P007U2_A198ProfesionalEstado, P007U2_A197ProfesionalEstadoCuenta, P007U2_A194ProfesionalTelefono, P007U2_A193ProfesionalLinkedin,
            P007U2_A192ProfesionalInstagram, P007U2_A191ProfesionalFacebook, P007U2_A190ProfesionalTwitter, P007U2_A44UbigeoCode, P007U2_A184PaisDescripcion, P007U2_A183ProfesionalDireccion, P007U2_A182ProfesionalTiempoCita, P007U2_A181ProfesionalColorCita, P007U2_A180ProfesionalColorDisponible, P007U2_A88ProfesionalCOP,
            P007U2_A179ProfesionalCorreo, P007U2_A178ProfesionalDescripcion, P007U2_A177ProfesionalSexo, P007U2_A174ProfesionalNroDocumento, P007U2_A173ProfesionalTipoDocumento, P007U2_A84ProfesionalNombres, P007U2_A86ProfesionalApellidoMaterno, P007U2_A85ProfesionalApellidoPaterno, P007U2_A188UbigeoDistrito, P007U2_A187UbigeoProvincia,
            P007U2_A186UbigeoDepartamento
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV67TFProfesionalTiempoCita_Sel ;
   private byte AV92TFProfesionalTerminosCondiciones_Sel ;
   private byte A182ProfesionalTiempoCita ;
   private byte AV161Wppacienteds_53_tfprofesionalterminoscondiciones_sel ;
   private short AV70TFPaisId ;
   private short AV71TFPaisId_To ;
   private short AV88TFSecUserId ;
   private short AV89TFSecUserId_To ;
   private short GXv_int3[] ;
   private short A43PaisId ;
   private short A6SecUserId ;
   private short AV139Wppacienteds_31_tfpaisid ;
   private short AV140Wppacienteds_32_tfpaisid_to ;
   private short AV157Wppacienteds_49_tfsecuserid ;
   private short AV158Wppacienteds_50_tfsecuserid_to ;
   private short AV17OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV35TFProfesionalId ;
   private int AV36TFProfesionalId_To ;
   private int AV102GXV1 ;
   private int AV103GXV2 ;
   private int AV104GXV3 ;
   private int AV105GXV4 ;
   private int AV106GXV5 ;
   private int AV107GXV6 ;
   private int A31ProfesionalId ;
   private int AV110Wppacienteds_2_tfprofesionalid ;
   private int AV111Wppacienteds_3_tfprofesionalid_to ;
   private int AV112Wppacienteds_4_tfprofesionaltipodocumento_sels_size ;
   private int AV125Wppacienteds_17_tfprofesionalsexo_sels_size ;
   private int AV136Wppacienteds_28_tfprofesionaltiempocita_sels_size ;
   private int AV162Wppacienteds_54_tfprofesionalestadocuenta_sels_size ;
   private int AV163Wppacienteds_55_tfprofesionalestado_sels_size ;
   private int AV164GXV7 ;
   private long AV99i ;
   private long AV32VisibleColumnCount ;
   private String AV39TFProfesionalTipoDocumento_Sel ;
   private String AV54TFProfesionalSexo_Sel ;
   private String AV62TFProfesionalColorDisponible_Sel ;
   private String AV61TFProfesionalColorDisponible ;
   private String AV64TFProfesionalColorCita_Sel ;
   private String AV63TFProfesionalColorCita ;
   private String AV75TFUbigeoCode_Sel ;
   private String AV74TFUbigeoCode ;
   private String AV87TFProfesionalTelefono_Sel ;
   private String AV86TFProfesionalTelefono ;
   private String AV95TFProfesionalEstadoCuenta_Sel ;
   private String AV98TFProfesionalEstado_Sel ;
   private String A173ProfesionalTipoDocumento ;
   private String A177ProfesionalSexo ;
   private String A180ProfesionalColorDisponible ;
   private String A181ProfesionalColorCita ;
   private String A44UbigeoCode ;
   private String A194ProfesionalTelefono ;
   private String A197ProfesionalEstadoCuenta ;
   private String A198ProfesionalEstado ;
   private String AV132Wppacienteds_24_tfprofesionalcolordisponible ;
   private String AV133Wppacienteds_25_tfprofesionalcolordisponible_sel ;
   private String AV134Wppacienteds_26_tfprofesionalcolorcita ;
   private String AV135Wppacienteds_27_tfprofesionalcolorcita_sel ;
   private String AV143Wppacienteds_35_tfubigeocode ;
   private String AV144Wppacienteds_36_tfubigeocode_sel ;
   private String AV155Wppacienteds_47_tfprofesionaltelefono ;
   private String AV156Wppacienteds_48_tfprofesionaltelefono_sel ;
   private String scmdbuf ;
   private String lV132Wppacienteds_24_tfprofesionalcolordisponible ;
   private String lV134Wppacienteds_26_tfprofesionalcolorcita ;
   private String lV143Wppacienteds_35_tfubigeocode ;
   private String lV155Wppacienteds_47_tfprofesionaltelefono ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private java.util.Date GXt_dtime6 ;
   private java.util.Date AV50TFProfesionalFechaNacimiento ;
   private java.util.Date AV51TFProfesionalFechaNacimiento_To ;
   private java.util.Date AV90TFProfesionalFechaRegistro ;
   private java.util.Date AV91TFProfesionalFechaRegistro_To ;
   private java.util.Date A176ProfesionalFechaNacimiento ;
   private java.util.Date A195ProfesionalFechaRegistro ;
   private java.util.Date AV123Wppacienteds_15_tfprofesionalfechanacimiento ;
   private java.util.Date AV124Wppacienteds_16_tfprofesionalfechanacimiento_to ;
   private java.util.Date AV159Wppacienteds_51_tfprofesionalfecharegistro ;
   private java.util.Date AV160Wppacienteds_52_tfprofesionalfecharegistro_to ;
   private boolean returnInSub ;
   private boolean A196ProfesionalTerminosCondiciones ;
   private boolean AV18OrderedDsc ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV37TFProfesionalTipoDocumento_SelsJson ;
   private String AV52TFProfesionalSexo_SelsJson ;
   private String AV65TFProfesionalTiempoCita_SelsJson ;
   private String AV93TFProfesionalEstadoCuenta_SelsJson ;
   private String AV96TFProfesionalEstado_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV19FilterFullText ;
   private String AV41TFProfesionalNroDocumento_Sel ;
   private String AV40TFProfesionalNroDocumento ;
   private String AV43TFProfesionalApellidoPaterno_Sel ;
   private String AV42TFProfesionalApellidoPaterno ;
   private String AV45TFProfesionalApellidoMaterno_Sel ;
   private String AV44TFProfesionalApellidoMaterno ;
   private String AV47TFProfesionalNombres_Sel ;
   private String AV46TFProfesionalNombres ;
   private String AV49TFProfesionalNombreCompleto2_Sel ;
   private String AV48TFProfesionalNombreCompleto2 ;
   private String AV56TFProfesionalDescripcion_Sel ;
   private String AV55TFProfesionalDescripcion ;
   private String AV58TFProfesionalCorreo_Sel ;
   private String AV57TFProfesionalCorreo ;
   private String AV60TFProfesionalCOP_Sel ;
   private String AV59TFProfesionalCOP ;
   private String AV69TFProfesionalDireccion_Sel ;
   private String AV68TFProfesionalDireccion ;
   private String AV73TFPaisDescripcion_Sel ;
   private String AV72TFPaisDescripcion ;
   private String AV77TFUbigeoNombre_Sel ;
   private String AV76TFUbigeoNombre ;
   private String AV79TFProfesionalTwitter_Sel ;
   private String AV78TFProfesionalTwitter ;
   private String AV81TFProfesionalFacebook_Sel ;
   private String AV80TFProfesionalFacebook ;
   private String AV83TFProfesionalInstagram_Sel ;
   private String AV82TFProfesionalInstagram ;
   private String AV85TFProfesionalLinkedin_Sel ;
   private String AV84TFProfesionalLinkedin ;
   private String A174ProfesionalNroDocumento ;
   private String A85ProfesionalApellidoPaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private String A84ProfesionalNombres ;
   private String A175ProfesionalNombreCompleto2 ;
   private String A178ProfesionalDescripcion ;
   private String A179ProfesionalCorreo ;
   private String A88ProfesionalCOP ;
   private String A183ProfesionalDireccion ;
   private String A184PaisDescripcion ;
   private String A185UbigeoNombre ;
   private String A190ProfesionalTwitter ;
   private String A191ProfesionalFacebook ;
   private String A192ProfesionalInstagram ;
   private String A193ProfesionalLinkedin ;
   private String AV109Wppacienteds_1_filterfulltext ;
   private String AV113Wppacienteds_5_tfprofesionalnrodocumento ;
   private String AV114Wppacienteds_6_tfprofesionalnrodocumento_sel ;
   private String AV115Wppacienteds_7_tfprofesionalapellidopaterno ;
   private String AV116Wppacienteds_8_tfprofesionalapellidopaterno_sel ;
   private String AV117Wppacienteds_9_tfprofesionalapellidomaterno ;
   private String AV118Wppacienteds_10_tfprofesionalapellidomaterno_sel ;
   private String AV119Wppacienteds_11_tfprofesionalnombres ;
   private String AV120Wppacienteds_12_tfprofesionalnombres_sel ;
   private String AV121Wppacienteds_13_tfprofesionalnombrecompleto2 ;
   private String AV122Wppacienteds_14_tfprofesionalnombrecompleto2_sel ;
   private String AV126Wppacienteds_18_tfprofesionaldescripcion ;
   private String AV127Wppacienteds_19_tfprofesionaldescripcion_sel ;
   private String AV128Wppacienteds_20_tfprofesionalcorreo ;
   private String AV129Wppacienteds_21_tfprofesionalcorreo_sel ;
   private String AV130Wppacienteds_22_tfprofesionalcop ;
   private String AV131Wppacienteds_23_tfprofesionalcop_sel ;
   private String AV137Wppacienteds_29_tfprofesionaldireccion ;
   private String AV138Wppacienteds_30_tfprofesionaldireccion_sel ;
   private String AV141Wppacienteds_33_tfpaisdescripcion ;
   private String AV142Wppacienteds_34_tfpaisdescripcion_sel ;
   private String AV145Wppacienteds_37_tfubigeonombre ;
   private String AV146Wppacienteds_38_tfubigeonombre_sel ;
   private String AV147Wppacienteds_39_tfprofesionaltwitter ;
   private String AV148Wppacienteds_40_tfprofesionaltwitter_sel ;
   private String AV149Wppacienteds_41_tfprofesionalfacebook ;
   private String AV150Wppacienteds_42_tfprofesionalfacebook_sel ;
   private String AV151Wppacienteds_43_tfprofesionalinstagram ;
   private String AV152Wppacienteds_44_tfprofesionalinstagram_sel ;
   private String AV153Wppacienteds_45_tfprofesionallinkedin ;
   private String AV154Wppacienteds_46_tfprofesionallinkedin_sel ;
   private String lV109Wppacienteds_1_filterfulltext ;
   private String lV113Wppacienteds_5_tfprofesionalnrodocumento ;
   private String lV115Wppacienteds_7_tfprofesionalapellidopaterno ;
   private String lV117Wppacienteds_9_tfprofesionalapellidomaterno ;
   private String lV119Wppacienteds_11_tfprofesionalnombres ;
   private String lV121Wppacienteds_13_tfprofesionalnombrecompleto2 ;
   private String lV126Wppacienteds_18_tfprofesionaldescripcion ;
   private String lV128Wppacienteds_20_tfprofesionalcorreo ;
   private String lV130Wppacienteds_22_tfprofesionalcop ;
   private String lV137Wppacienteds_29_tfprofesionaldireccion ;
   private String lV141Wppacienteds_33_tfpaisdescripcion ;
   private String lV145Wppacienteds_37_tfubigeonombre ;
   private String lV147Wppacienteds_39_tfprofesionaltwitter ;
   private String lV149Wppacienteds_41_tfprofesionalfacebook ;
   private String lV151Wppacienteds_43_tfprofesionalinstagram ;
   private String lV153Wppacienteds_45_tfprofesionallinkedin ;
   private String A186UbigeoDepartamento ;
   private String A187UbigeoProvincia ;
   private String A188UbigeoDistrito ;
   private GXSimpleCollection<Byte> AV66TFProfesionalTiempoCita_Sels ;
   private GXSimpleCollection<Byte> AV136Wppacienteds_28_tfprofesionaltiempocita_sels ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV38TFProfesionalTipoDocumento_Sels ;
   private GXSimpleCollection<String> AV53TFProfesionalSexo_Sels ;
   private GXSimpleCollection<String> AV94TFProfesionalEstadoCuenta_Sels ;
   private GXSimpleCollection<String> AV97TFProfesionalEstado_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P007U2_A196ProfesionalTerminosCondiciones ;
   private java.util.Date[] P007U2_A195ProfesionalFechaRegistro ;
   private short[] P007U2_A6SecUserId ;
   private short[] P007U2_A43PaisId ;
   private java.util.Date[] P007U2_A176ProfesionalFechaNacimiento ;
   private int[] P007U2_A31ProfesionalId ;
   private String[] P007U2_A198ProfesionalEstado ;
   private String[] P007U2_A197ProfesionalEstadoCuenta ;
   private String[] P007U2_A194ProfesionalTelefono ;
   private String[] P007U2_A193ProfesionalLinkedin ;
   private String[] P007U2_A192ProfesionalInstagram ;
   private String[] P007U2_A191ProfesionalFacebook ;
   private String[] P007U2_A190ProfesionalTwitter ;
   private String[] P007U2_A44UbigeoCode ;
   private String[] P007U2_A184PaisDescripcion ;
   private String[] P007U2_A183ProfesionalDireccion ;
   private byte[] P007U2_A182ProfesionalTiempoCita ;
   private String[] P007U2_A181ProfesionalColorCita ;
   private String[] P007U2_A180ProfesionalColorDisponible ;
   private String[] P007U2_A88ProfesionalCOP ;
   private String[] P007U2_A179ProfesionalCorreo ;
   private String[] P007U2_A178ProfesionalDescripcion ;
   private String[] P007U2_A177ProfesionalSexo ;
   private String[] P007U2_A174ProfesionalNroDocumento ;
   private String[] P007U2_A173ProfesionalTipoDocumento ;
   private String[] P007U2_A84ProfesionalNombres ;
   private String[] P007U2_A86ProfesionalApellidoMaterno ;
   private String[] P007U2_A85ProfesionalApellidoPaterno ;
   private String[] P007U2_A188UbigeoDistrito ;
   private String[] P007U2_A187UbigeoProvincia ;
   private String[] P007U2_A186UbigeoDepartamento ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc2[] ;
   private GXSimpleCollection<String> AV112Wppacienteds_4_tfprofesionaltipodocumento_sels ;
   private GXSimpleCollection<String> AV125Wppacienteds_17_tfprofesionalsexo_sels ;
   private GXSimpleCollection<String> AV162Wppacienteds_54_tfprofesionalestadocuenta_sels ;
   private GXSimpleCollection<String> AV163Wppacienteds_55_tfprofesionalestado_sels ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV24ColumnsSelector ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelectorAux ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector7[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column AV26ColumnsSelector_Column ;
}

final  class wppacienteexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P007U2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A173ProfesionalTipoDocumento ,
                                          GXSimpleCollection<String> AV112Wppacienteds_4_tfprofesionaltipodocumento_sels ,
                                          String A177ProfesionalSexo ,
                                          GXSimpleCollection<String> AV125Wppacienteds_17_tfprofesionalsexo_sels ,
                                          byte A182ProfesionalTiempoCita ,
                                          GXSimpleCollection<Byte> AV136Wppacienteds_28_tfprofesionaltiempocita_sels ,
                                          String A197ProfesionalEstadoCuenta ,
                                          GXSimpleCollection<String> AV162Wppacienteds_54_tfprofesionalestadocuenta_sels ,
                                          String A198ProfesionalEstado ,
                                          GXSimpleCollection<String> AV163Wppacienteds_55_tfprofesionalestado_sels ,
                                          String AV109Wppacienteds_1_filterfulltext ,
                                          int AV110Wppacienteds_2_tfprofesionalid ,
                                          int AV111Wppacienteds_3_tfprofesionalid_to ,
                                          int AV112Wppacienteds_4_tfprofesionaltipodocumento_sels_size ,
                                          String AV114Wppacienteds_6_tfprofesionalnrodocumento_sel ,
                                          String AV113Wppacienteds_5_tfprofesionalnrodocumento ,
                                          String AV116Wppacienteds_8_tfprofesionalapellidopaterno_sel ,
                                          String AV115Wppacienteds_7_tfprofesionalapellidopaterno ,
                                          String AV118Wppacienteds_10_tfprofesionalapellidomaterno_sel ,
                                          String AV117Wppacienteds_9_tfprofesionalapellidomaterno ,
                                          String AV120Wppacienteds_12_tfprofesionalnombres_sel ,
                                          String AV119Wppacienteds_11_tfprofesionalnombres ,
                                          String AV122Wppacienteds_14_tfprofesionalnombrecompleto2_sel ,
                                          String AV121Wppacienteds_13_tfprofesionalnombrecompleto2 ,
                                          java.util.Date AV123Wppacienteds_15_tfprofesionalfechanacimiento ,
                                          java.util.Date AV124Wppacienteds_16_tfprofesionalfechanacimiento_to ,
                                          int AV125Wppacienteds_17_tfprofesionalsexo_sels_size ,
                                          String AV127Wppacienteds_19_tfprofesionaldescripcion_sel ,
                                          String AV126Wppacienteds_18_tfprofesionaldescripcion ,
                                          String AV129Wppacienteds_21_tfprofesionalcorreo_sel ,
                                          String AV128Wppacienteds_20_tfprofesionalcorreo ,
                                          String AV131Wppacienteds_23_tfprofesionalcop_sel ,
                                          String AV130Wppacienteds_22_tfprofesionalcop ,
                                          String AV133Wppacienteds_25_tfprofesionalcolordisponible_sel ,
                                          String AV132Wppacienteds_24_tfprofesionalcolordisponible ,
                                          String AV135Wppacienteds_27_tfprofesionalcolorcita_sel ,
                                          String AV134Wppacienteds_26_tfprofesionalcolorcita ,
                                          int AV136Wppacienteds_28_tfprofesionaltiempocita_sels_size ,
                                          String AV138Wppacienteds_30_tfprofesionaldireccion_sel ,
                                          String AV137Wppacienteds_29_tfprofesionaldireccion ,
                                          short AV139Wppacienteds_31_tfpaisid ,
                                          short AV140Wppacienteds_32_tfpaisid_to ,
                                          String AV142Wppacienteds_34_tfpaisdescripcion_sel ,
                                          String AV141Wppacienteds_33_tfpaisdescripcion ,
                                          String AV144Wppacienteds_36_tfubigeocode_sel ,
                                          String AV143Wppacienteds_35_tfubigeocode ,
                                          String AV146Wppacienteds_38_tfubigeonombre_sel ,
                                          String AV145Wppacienteds_37_tfubigeonombre ,
                                          String AV148Wppacienteds_40_tfprofesionaltwitter_sel ,
                                          String AV147Wppacienteds_39_tfprofesionaltwitter ,
                                          String AV150Wppacienteds_42_tfprofesionalfacebook_sel ,
                                          String AV149Wppacienteds_41_tfprofesionalfacebook ,
                                          String AV152Wppacienteds_44_tfprofesionalinstagram_sel ,
                                          String AV151Wppacienteds_43_tfprofesionalinstagram ,
                                          String AV154Wppacienteds_46_tfprofesionallinkedin_sel ,
                                          String AV153Wppacienteds_45_tfprofesionallinkedin ,
                                          String AV156Wppacienteds_48_tfprofesionaltelefono_sel ,
                                          String AV155Wppacienteds_47_tfprofesionaltelefono ,
                                          short AV157Wppacienteds_49_tfsecuserid ,
                                          short AV158Wppacienteds_50_tfsecuserid_to ,
                                          java.util.Date AV159Wppacienteds_51_tfprofesionalfecharegistro ,
                                          java.util.Date AV160Wppacienteds_52_tfprofesionalfecharegistro_to ,
                                          byte AV161Wppacienteds_53_tfprofesionalterminoscondiciones_sel ,
                                          int AV162Wppacienteds_54_tfprofesionalestadocuenta_sels_size ,
                                          int AV163Wppacienteds_55_tfprofesionalestado_sels_size ,
                                          int A31ProfesionalId ,
                                          String A174ProfesionalNroDocumento ,
                                          String A85ProfesionalApellidoPaterno ,
                                          String A86ProfesionalApellidoMaterno ,
                                          String A84ProfesionalNombres ,
                                          String A178ProfesionalDescripcion ,
                                          String A179ProfesionalCorreo ,
                                          String A88ProfesionalCOP ,
                                          String A180ProfesionalColorDisponible ,
                                          String A181ProfesionalColorCita ,
                                          String A183ProfesionalDireccion ,
                                          short A43PaisId ,
                                          String A184PaisDescripcion ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito ,
                                          String A190ProfesionalTwitter ,
                                          String A191ProfesionalFacebook ,
                                          String A192ProfesionalInstagram ,
                                          String A193ProfesionalLinkedin ,
                                          String A194ProfesionalTelefono ,
                                          short A6SecUserId ,
                                          java.util.Date A176ProfesionalFechaNacimiento ,
                                          java.util.Date A195ProfesionalFechaRegistro ,
                                          boolean A196ProfesionalTerminosCondiciones ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int9 = new byte[85];
      Object[] GXv_Object10 = new Object[2];
      scmdbuf = "SELECT T1.[ProfesionalTerminosCondiciones], T1.[ProfesionalFechaRegistro], T1.[SecUserId], T1.[PaisId], T1.[ProfesionalFechaNacimiento], T1.[ProfesionalId], T1.[ProfesionalEstado]," ;
      scmdbuf += " T1.[ProfesionalEstadoCuenta], T1.[ProfesionalTelefono], T1.[ProfesionalLinkedin], T1.[ProfesionalInstagram], T1.[ProfesionalFacebook], T1.[ProfesionalTwitter]," ;
      scmdbuf += " T1.[UbigeoCode], T2.[PaisDescripcion], T1.[ProfesionalDireccion], T1.[ProfesionalTiempoCita], T1.[ProfesionalColorCita], T1.[ProfesionalColorDisponible], T1.[ProfesionalCOP]," ;
      scmdbuf += " T1.[ProfesionalCorreo], T1.[ProfesionalDescripcion], T1.[ProfesionalSexo], T1.[ProfesionalNroDocumento], T1.[ProfesionalTipoDocumento], T1.[ProfesionalNombres]," ;
      scmdbuf += " T1.[ProfesionalApellidoMaterno], T1.[ProfesionalApellidoPaterno], T3.[UbigeoDistrito], T3.[UbigeoProvincia], T3.[UbigeoDepartamento] FROM (([Profesional] T1 INNER" ;
      scmdbuf += " JOIN [Pais] T2 ON T2.[PaisId] = T1.[PaisId]) INNER JOIN [Ubigeo] T3 ON T3.[UbigeoCode] = T1.[UbigeoCode])" ;
      if ( ! (GXutil.strcmp("", AV109Wppacienteds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( 'dni' like '%' + LOWER(?) and T1.[ProfesionalTipoDocumento] = '1') or ( 'ruc' like '%' + LOWER(?) and T1.[ProfesionalTipoDocumento] = '6') or ( 'libreta electoral' like '%' + LOWER(?) and T1.[ProfesionalTipoDocumento] = '2') or ( 'carnet de extranjeria' like '%' + LOWER(?) and T1.[ProfesionalTipoDocumento] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[ProfesionalTipoDocumento] = '7') or ( 'sin documento' like '%' + LOWER(?) and T1.[ProfesionalTipoDocumento] = '0') or ( T1.[ProfesionalNroDocumento] like '%' + ?) or ( T1.[ProfesionalApellidoPaterno] like '%' + ?) or ( T1.[ProfesionalApellidoMaterno] like '%' + ?) or ( T1.[ProfesionalNombres] like '%' + ?) or ( T1.[ProfesionalApellidoPaterno] + ' ' + T1.[ProfesionalApellidoMaterno] + ', ' + T1.[ProfesionalNombres] like '%' + ?) or ( 'masculino' like '%' + LOWER(?) and T1.[ProfesionalSexo] = 'M') or ( 'femenino' like '%' + LOWER(?) and T1.[ProfesionalSexo] = 'F') or ( T1.[ProfesionalDescripcion] like '%' + ?) or ( T1.[ProfesionalCorreo] like '%' + ?) or ( T1.[ProfesionalCOP] like '%' + ?) or ( T1.[ProfesionalColorDisponible] like '%' + ?) or ( T1.[ProfesionalColorCita] like '%' + ?) or ( '30 minutos' like '%' + LOWER(?) and T1.[ProfesionalTiempoCita] = 30) or ( '1 hora' like '%' + LOWER(?) and T1.[ProfesionalTiempoCita] = 60) or ( T1.[ProfesionalDireccion] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PaisId] AS decimal(4,0))) like '%' + ?) or ( T2.[PaisDescripcion] like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like '%' + ?) or ( T1.[ProfesionalTwitter] like '%' + ?) or ( T1.[ProfesionalFacebook] like '%' + ?) or ( T1.[ProfesionalInstagram] like '%' + ?) or ( T1.[ProfesionalLinkedin] like '%' + ?) or ( T1.[ProfesionalTelefono] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[SecUserId] AS decimal(4,0))) like '%' + ?) or ( 'cuenta verificada' like '%' + LOWER(?) and T1.[ProfesionalEstadoCuenta] = 'CV') or ( 'cuenta por verificar' like '%' + LOWER(?) and T1.[ProfesionalEstadoCuenta] = 'CP') or ( 'activo' like '%' + LOWER(?) and T1.[ProfesionalEstado] = 'A') or ( 'pendiente' like '%' + LOWER(?) and T1.[ProfesionalEstado] = 'P') or ( 'inactivo' like '%' + LOWER(?) and T1.[ProfesionalEstado] = 'I'))");
      }
      else
      {
         GXv_int9[0] = (byte)(1) ;
         GXv_int9[1] = (byte)(1) ;
         GXv_int9[2] = (byte)(1) ;
         GXv_int9[3] = (byte)(1) ;
         GXv_int9[4] = (byte)(1) ;
         GXv_int9[5] = (byte)(1) ;
         GXv_int9[6] = (byte)(1) ;
         GXv_int9[7] = (byte)(1) ;
         GXv_int9[8] = (byte)(1) ;
         GXv_int9[9] = (byte)(1) ;
         GXv_int9[10] = (byte)(1) ;
         GXv_int9[11] = (byte)(1) ;
         GXv_int9[12] = (byte)(1) ;
         GXv_int9[13] = (byte)(1) ;
         GXv_int9[14] = (byte)(1) ;
         GXv_int9[15] = (byte)(1) ;
         GXv_int9[16] = (byte)(1) ;
         GXv_int9[17] = (byte)(1) ;
         GXv_int9[18] = (byte)(1) ;
         GXv_int9[19] = (byte)(1) ;
         GXv_int9[20] = (byte)(1) ;
         GXv_int9[21] = (byte)(1) ;
         GXv_int9[22] = (byte)(1) ;
         GXv_int9[23] = (byte)(1) ;
         GXv_int9[24] = (byte)(1) ;
         GXv_int9[25] = (byte)(1) ;
         GXv_int9[26] = (byte)(1) ;
         GXv_int9[27] = (byte)(1) ;
         GXv_int9[28] = (byte)(1) ;
         GXv_int9[29] = (byte)(1) ;
         GXv_int9[30] = (byte)(1) ;
         GXv_int9[31] = (byte)(1) ;
         GXv_int9[32] = (byte)(1) ;
         GXv_int9[33] = (byte)(1) ;
         GXv_int9[34] = (byte)(1) ;
         GXv_int9[35] = (byte)(1) ;
         GXv_int9[36] = (byte)(1) ;
      }
      if ( ! (0==AV110Wppacienteds_2_tfprofesionalid) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int9[37] = (byte)(1) ;
      }
      if ( ! (0==AV111Wppacienteds_3_tfprofesionalid_to) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int9[38] = (byte)(1) ;
      }
      if ( AV112Wppacienteds_4_tfprofesionaltipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV112Wppacienteds_4_tfprofesionaltipodocumento_sels, "T1.[ProfesionalTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV114Wppacienteds_6_tfprofesionalnrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV113Wppacienteds_5_tfprofesionalnrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalNroDocumento] like ?)");
      }
      else
      {
         GXv_int9[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV114Wppacienteds_6_tfprofesionalnrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalNroDocumento] = ?)");
      }
      else
      {
         GXv_int9[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV116Wppacienteds_8_tfprofesionalapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV115Wppacienteds_7_tfprofesionalapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int9[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV116Wppacienteds_8_tfprofesionalapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int9[42] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV118Wppacienteds_10_tfprofesionalapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV117Wppacienteds_9_tfprofesionalapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int9[43] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV118Wppacienteds_10_tfprofesionalapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int9[44] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV120Wppacienteds_12_tfprofesionalnombres_sel)==0) && ( ! (GXutil.strcmp("", AV119Wppacienteds_11_tfprofesionalnombres)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalNombres] like ?)");
      }
      else
      {
         GXv_int9[45] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV120Wppacienteds_12_tfprofesionalnombres_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalNombres] = ?)");
      }
      else
      {
         GXv_int9[46] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV122Wppacienteds_14_tfprofesionalnombrecompleto2_sel)==0) && ( ! (GXutil.strcmp("", AV121Wppacienteds_13_tfprofesionalnombrecompleto2)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalApellidoPaterno] + ' ' + T1.[ProfesionalApellidoMaterno] + ', ' + T1.[ProfesionalNombres] like ?)");
      }
      else
      {
         GXv_int9[47] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV122Wppacienteds_14_tfprofesionalnombrecompleto2_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalApellidoPaterno] + ' ' + T1.[ProfesionalApellidoMaterno] + ', ' + T1.[ProfesionalNombres] = ?)");
      }
      else
      {
         GXv_int9[48] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV123Wppacienteds_15_tfprofesionalfechanacimiento)) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalFechaNacimiento] >= ?)");
      }
      else
      {
         GXv_int9[49] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV124Wppacienteds_16_tfprofesionalfechanacimiento_to)) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalFechaNacimiento] <= ?)");
      }
      else
      {
         GXv_int9[50] = (byte)(1) ;
      }
      if ( AV125Wppacienteds_17_tfprofesionalsexo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV125Wppacienteds_17_tfprofesionalsexo_sels, "T1.[ProfesionalSexo] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV127Wppacienteds_19_tfprofesionaldescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV126Wppacienteds_18_tfprofesionaldescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalDescripcion] like ?)");
      }
      else
      {
         GXv_int9[51] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV127Wppacienteds_19_tfprofesionaldescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalDescripcion] = ?)");
      }
      else
      {
         GXv_int9[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV129Wppacienteds_21_tfprofesionalcorreo_sel)==0) && ( ! (GXutil.strcmp("", AV128Wppacienteds_20_tfprofesionalcorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalCorreo] like ?)");
      }
      else
      {
         GXv_int9[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV129Wppacienteds_21_tfprofesionalcorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalCorreo] = ?)");
      }
      else
      {
         GXv_int9[54] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV131Wppacienteds_23_tfprofesionalcop_sel)==0) && ( ! (GXutil.strcmp("", AV130Wppacienteds_22_tfprofesionalcop)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalCOP] like ?)");
      }
      else
      {
         GXv_int9[55] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV131Wppacienteds_23_tfprofesionalcop_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalCOP] = ?)");
      }
      else
      {
         GXv_int9[56] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV133Wppacienteds_25_tfprofesionalcolordisponible_sel)==0) && ( ! (GXutil.strcmp("", AV132Wppacienteds_24_tfprofesionalcolordisponible)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalColorDisponible] like ?)");
      }
      else
      {
         GXv_int9[57] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV133Wppacienteds_25_tfprofesionalcolordisponible_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalColorDisponible] = ?)");
      }
      else
      {
         GXv_int9[58] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV135Wppacienteds_27_tfprofesionalcolorcita_sel)==0) && ( ! (GXutil.strcmp("", AV134Wppacienteds_26_tfprofesionalcolorcita)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalColorCita] like ?)");
      }
      else
      {
         GXv_int9[59] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV135Wppacienteds_27_tfprofesionalcolorcita_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalColorCita] = ?)");
      }
      else
      {
         GXv_int9[60] = (byte)(1) ;
      }
      if ( AV136Wppacienteds_28_tfprofesionaltiempocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV136Wppacienteds_28_tfprofesionaltiempocita_sels, "T1.[ProfesionalTiempoCita] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV138Wppacienteds_30_tfprofesionaldireccion_sel)==0) && ( ! (GXutil.strcmp("", AV137Wppacienteds_29_tfprofesionaldireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalDireccion] like ?)");
      }
      else
      {
         GXv_int9[61] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV138Wppacienteds_30_tfprofesionaldireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalDireccion] = ?)");
      }
      else
      {
         GXv_int9[62] = (byte)(1) ;
      }
      if ( ! (0==AV139Wppacienteds_31_tfpaisid) )
      {
         addWhere(sWhereString, "(T1.[PaisId] >= ?)");
      }
      else
      {
         GXv_int9[63] = (byte)(1) ;
      }
      if ( ! (0==AV140Wppacienteds_32_tfpaisid_to) )
      {
         addWhere(sWhereString, "(T1.[PaisId] <= ?)");
      }
      else
      {
         GXv_int9[64] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV142Wppacienteds_34_tfpaisdescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV141Wppacienteds_33_tfpaisdescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] like ?)");
      }
      else
      {
         GXv_int9[65] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV142Wppacienteds_34_tfpaisdescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] = ?)");
      }
      else
      {
         GXv_int9[66] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV144Wppacienteds_36_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV143Wppacienteds_35_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int9[67] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV144Wppacienteds_36_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int9[68] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV146Wppacienteds_38_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV145Wppacienteds_37_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int9[69] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV146Wppacienteds_38_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int9[70] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV148Wppacienteds_40_tfprofesionaltwitter_sel)==0) && ( ! (GXutil.strcmp("", AV147Wppacienteds_39_tfprofesionaltwitter)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalTwitter] like ?)");
      }
      else
      {
         GXv_int9[71] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV148Wppacienteds_40_tfprofesionaltwitter_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalTwitter] = ?)");
      }
      else
      {
         GXv_int9[72] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV150Wppacienteds_42_tfprofesionalfacebook_sel)==0) && ( ! (GXutil.strcmp("", AV149Wppacienteds_41_tfprofesionalfacebook)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalFacebook] like ?)");
      }
      else
      {
         GXv_int9[73] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV150Wppacienteds_42_tfprofesionalfacebook_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalFacebook] = ?)");
      }
      else
      {
         GXv_int9[74] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV152Wppacienteds_44_tfprofesionalinstagram_sel)==0) && ( ! (GXutil.strcmp("", AV151Wppacienteds_43_tfprofesionalinstagram)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalInstagram] like ?)");
      }
      else
      {
         GXv_int9[75] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV152Wppacienteds_44_tfprofesionalinstagram_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalInstagram] = ?)");
      }
      else
      {
         GXv_int9[76] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV154Wppacienteds_46_tfprofesionallinkedin_sel)==0) && ( ! (GXutil.strcmp("", AV153Wppacienteds_45_tfprofesionallinkedin)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalLinkedin] like ?)");
      }
      else
      {
         GXv_int9[77] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV154Wppacienteds_46_tfprofesionallinkedin_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalLinkedin] = ?)");
      }
      else
      {
         GXv_int9[78] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV156Wppacienteds_48_tfprofesionaltelefono_sel)==0) && ( ! (GXutil.strcmp("", AV155Wppacienteds_47_tfprofesionaltelefono)==0) ) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalTelefono] like ?)");
      }
      else
      {
         GXv_int9[79] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV156Wppacienteds_48_tfprofesionaltelefono_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalTelefono] = ?)");
      }
      else
      {
         GXv_int9[80] = (byte)(1) ;
      }
      if ( ! (0==AV157Wppacienteds_49_tfsecuserid) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] >= ?)");
      }
      else
      {
         GXv_int9[81] = (byte)(1) ;
      }
      if ( ! (0==AV158Wppacienteds_50_tfsecuserid_to) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] <= ?)");
      }
      else
      {
         GXv_int9[82] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV159Wppacienteds_51_tfprofesionalfecharegistro)) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalFechaRegistro] >= ?)");
      }
      else
      {
         GXv_int9[83] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV160Wppacienteds_52_tfprofesionalfecharegistro_to)) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalFechaRegistro] <= ?)");
      }
      else
      {
         GXv_int9[84] = (byte)(1) ;
      }
      if ( AV161Wppacienteds_53_tfprofesionalterminoscondiciones_sel == 1 )
      {
         addWhere(sWhereString, "(T1.[ProfesionalTerminosCondiciones] = 1)");
      }
      if ( AV161Wppacienteds_53_tfprofesionalterminoscondiciones_sel == 2 )
      {
         addWhere(sWhereString, "(T1.[ProfesionalTerminosCondiciones] = 0)");
      }
      if ( AV162Wppacienteds_54_tfprofesionalestadocuenta_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV162Wppacienteds_54_tfprofesionalestadocuenta_sels, "T1.[ProfesionalEstadoCuenta] IN (", ")")+")");
      }
      if ( AV163Wppacienteds_55_tfprofesionalestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV163Wppacienteds_55_tfprofesionalestado_sels, "T1.[ProfesionalEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalId]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalTipoDocumento]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalTipoDocumento] DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalNroDocumento]" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalNroDocumento] DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalApellidoPaterno]" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalApellidoPaterno] DESC" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalApellidoMaterno]" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalApellidoMaterno] DESC" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalNombres]" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalNombres] DESC" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalFechaNacimiento]" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalFechaNacimiento] DESC" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalSexo]" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalSexo] DESC" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalDescripcion]" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalDescripcion] DESC" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalCorreo]" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalCorreo] DESC" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalCOP]" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalCOP] DESC" ;
      }
      else if ( ( AV17OrderedBy == 12 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalColorDisponible]" ;
      }
      else if ( ( AV17OrderedBy == 12 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalColorDisponible] DESC" ;
      }
      else if ( ( AV17OrderedBy == 13 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalColorCita]" ;
      }
      else if ( ( AV17OrderedBy == 13 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalColorCita] DESC" ;
      }
      else if ( ( AV17OrderedBy == 14 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalTiempoCita]" ;
      }
      else if ( ( AV17OrderedBy == 14 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalTiempoCita] DESC" ;
      }
      else if ( ( AV17OrderedBy == 15 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalDireccion]" ;
      }
      else if ( ( AV17OrderedBy == 15 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalDireccion] DESC" ;
      }
      else if ( ( AV17OrderedBy == 16 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PaisId]" ;
      }
      else if ( ( AV17OrderedBy == 16 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PaisId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 17 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[PaisDescripcion]" ;
      }
      else if ( ( AV17OrderedBy == 17 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[PaisDescripcion] DESC" ;
      }
      else if ( ( AV17OrderedBy == 18 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[UbigeoCode]" ;
      }
      else if ( ( AV17OrderedBy == 18 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[UbigeoCode] DESC" ;
      }
      else if ( ( AV17OrderedBy == 19 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalTwitter]" ;
      }
      else if ( ( AV17OrderedBy == 19 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalTwitter] DESC" ;
      }
      else if ( ( AV17OrderedBy == 20 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalFacebook]" ;
      }
      else if ( ( AV17OrderedBy == 20 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalFacebook] DESC" ;
      }
      else if ( ( AV17OrderedBy == 21 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalInstagram]" ;
      }
      else if ( ( AV17OrderedBy == 21 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalInstagram] DESC" ;
      }
      else if ( ( AV17OrderedBy == 22 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalLinkedin]" ;
      }
      else if ( ( AV17OrderedBy == 22 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalLinkedin] DESC" ;
      }
      else if ( ( AV17OrderedBy == 23 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalTelefono]" ;
      }
      else if ( ( AV17OrderedBy == 23 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalTelefono] DESC" ;
      }
      else if ( ( AV17OrderedBy == 24 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SecUserId]" ;
      }
      else if ( ( AV17OrderedBy == 24 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SecUserId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 25 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalFechaRegistro]" ;
      }
      else if ( ( AV17OrderedBy == 25 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalFechaRegistro] DESC" ;
      }
      else if ( ( AV17OrderedBy == 26 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalTerminosCondiciones]" ;
      }
      else if ( ( AV17OrderedBy == 26 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalTerminosCondiciones] DESC" ;
      }
      else if ( ( AV17OrderedBy == 27 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalEstadoCuenta]" ;
      }
      else if ( ( AV17OrderedBy == 27 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalEstadoCuenta] DESC" ;
      }
      else if ( ( AV17OrderedBy == 28 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalEstado]" ;
      }
      else if ( ( AV17OrderedBy == 28 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProfesionalEstado] DESC" ;
      }
      GXv_Object10[0] = scmdbuf ;
      GXv_Object10[1] = GXv_int9 ;
      return GXv_Object10 ;
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
                  return conditional_P007U2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (java.util.Date)dynConstraints[24] , (java.util.Date)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , (String)dynConstraints[31] , (String)dynConstraints[32] , (String)dynConstraints[33] , (String)dynConstraints[34] , (String)dynConstraints[35] , (String)dynConstraints[36] , ((Number) dynConstraints[37]).intValue() , (String)dynConstraints[38] , (String)dynConstraints[39] , ((Number) dynConstraints[40]).shortValue() , ((Number) dynConstraints[41]).shortValue() , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , (String)dynConstraints[48] , (String)dynConstraints[49] , (String)dynConstraints[50] , (String)dynConstraints[51] , (String)dynConstraints[52] , (String)dynConstraints[53] , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , (String)dynConstraints[57] , ((Number) dynConstraints[58]).shortValue() , ((Number) dynConstraints[59]).shortValue() , (java.util.Date)dynConstraints[60] , (java.util.Date)dynConstraints[61] , ((Number) dynConstraints[62]).byteValue() , ((Number) dynConstraints[63]).intValue() , ((Number) dynConstraints[64]).intValue() , ((Number) dynConstraints[65]).intValue() , (String)dynConstraints[66] , (String)dynConstraints[67] , (String)dynConstraints[68] , (String)dynConstraints[69] , (String)dynConstraints[70] , (String)dynConstraints[71] , (String)dynConstraints[72] , (String)dynConstraints[73] , (String)dynConstraints[74] , (String)dynConstraints[75] , ((Number) dynConstraints[76]).shortValue() , (String)dynConstraints[77] , (String)dynConstraints[78] , (String)dynConstraints[79] , (String)dynConstraints[80] , (String)dynConstraints[81] , (String)dynConstraints[82] , (String)dynConstraints[83] , (String)dynConstraints[84] , (String)dynConstraints[85] , (String)dynConstraints[86] , ((Number) dynConstraints[87]).shortValue() , (java.util.Date)dynConstraints[88] , (java.util.Date)dynConstraints[89] , ((Boolean) dynConstraints[90]).booleanValue() , ((Number) dynConstraints[91]).shortValue() , ((Boolean) dynConstraints[92]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P007U2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 2);
               ((String[]) buf[7])[0] = rslt.getString(8, 2);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getString(14, 10);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((byte[]) buf[16])[0] = rslt.getByte(17);
               ((String[]) buf[17])[0] = rslt.getString(18, 20);
               ((String[]) buf[18])[0] = rslt.getString(19, 20);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((String[]) buf[21])[0] = rslt.getVarchar(22);
               ((String[]) buf[22])[0] = rslt.getString(23, 1);
               ((String[]) buf[23])[0] = rslt.getVarchar(24);
               ((String[]) buf[24])[0] = rslt.getString(25, 1);
               ((String[]) buf[25])[0] = rslt.getVarchar(26);
               ((String[]) buf[26])[0] = rslt.getVarchar(27);
               ((String[]) buf[27])[0] = rslt.getVarchar(28);
               ((String[]) buf[28])[0] = rslt.getVarchar(29);
               ((String[]) buf[29])[0] = rslt.getVarchar(30);
               ((String[]) buf[30])[0] = rslt.getVarchar(31);
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
                  stmt.setVarchar(sIdx, (String)parms[85], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[88], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[89], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[92], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[93], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[104], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[105], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[108], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[109], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[110], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[111], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[112], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[113], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[116], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[117], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[118], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[119], 100);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[120], 100);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[121], 100);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[122]).intValue());
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[123]).intValue());
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[124], 15);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[125], 15);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[126], 50);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[127], 50);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[128], 50);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[129], 50);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[130], 50);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[131], 50);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[132], 100);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[133], 100);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[134]);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[135]);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[136], 5000);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[137], 5000);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[138], 100);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[139], 100);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[140], 40);
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[141], 40);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[142], 20);
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[143], 20);
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[144], 20);
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[145], 20);
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[146], 200);
               }
               if ( ((Number) parms[62]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[147], 200);
               }
               if ( ((Number) parms[63]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[148]).shortValue());
               }
               if ( ((Number) parms[64]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[149]).shortValue());
               }
               if ( ((Number) parms[65]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[150], 80);
               }
               if ( ((Number) parms[66]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[151], 80);
               }
               if ( ((Number) parms[67]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[152], 10);
               }
               if ( ((Number) parms[68]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[153], 10);
               }
               if ( ((Number) parms[69]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[154], 100);
               }
               if ( ((Number) parms[70]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[155], 100);
               }
               if ( ((Number) parms[71]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[156], 1000);
               }
               if ( ((Number) parms[72]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[157], 1000);
               }
               if ( ((Number) parms[73]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[158], 1000);
               }
               if ( ((Number) parms[74]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[159], 1000);
               }
               if ( ((Number) parms[75]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[160], 1000);
               }
               if ( ((Number) parms[76]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[161], 1000);
               }
               if ( ((Number) parms[77]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[162], 1000);
               }
               if ( ((Number) parms[78]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[163], 1000);
               }
               if ( ((Number) parms[79]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[164], 20);
               }
               if ( ((Number) parms[80]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[165], 20);
               }
               if ( ((Number) parms[81]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[166]).shortValue());
               }
               if ( ((Number) parms[82]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[167]).shortValue());
               }
               if ( ((Number) parms[83]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[168]);
               }
               if ( ((Number) parms[84]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[169]);
               }
               return;
      }
   }

}

