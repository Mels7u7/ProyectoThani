package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcmostrardoctoresporfiltro extends GXProcedure
{
   public prcmostrardoctoresporfiltro( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcmostrardoctoresporfiltro.class ), "" );
   }

   public prcmostrardoctoresporfiltro( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( String aP0 ,
                            int aP1 ,
                            String aP2 ,
                            java.util.Date aP3 ,
                            String aP4 ,
                            String aP5 ,
                            String aP6 ,
                            String aP7 ,
                            String aP8 ,
                            String aP9 ,
                            GXBaseCollection<com.projectthani.SdtSDTEspecialidad> aP10 ,
                            GXBaseCollection<com.projectthani.SdtSDTRangoPrecios> aP11 ,
                            String aP12 ,
                            String aP13 ,
                            String aP14 ,
                            GXBaseCollection<com.projectthani.SdtSDTDoctores>[] aP15 )
   {
      prcmostrardoctoresporfiltro.this.aP16 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16);
      return aP16[0];
   }

   public void execute( String aP0 ,
                        int aP1 ,
                        String aP2 ,
                        java.util.Date aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        String aP8 ,
                        String aP9 ,
                        GXBaseCollection<com.projectthani.SdtSDTEspecialidad> aP10 ,
                        GXBaseCollection<com.projectthani.SdtSDTRangoPrecios> aP11 ,
                        String aP12 ,
                        String aP13 ,
                        String aP14 ,
                        GXBaseCollection<com.projectthani.SdtSDTDoctores>[] aP15 ,
                        short[] aP16 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16);
   }

   private void execute_int( String aP0 ,
                             int aP1 ,
                             String aP2 ,
                             java.util.Date aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 ,
                             String aP9 ,
                             GXBaseCollection<com.projectthani.SdtSDTEspecialidad> aP10 ,
                             GXBaseCollection<com.projectthani.SdtSDTRangoPrecios> aP11 ,
                             String aP12 ,
                             String aP13 ,
                             String aP14 ,
                             GXBaseCollection<com.projectthani.SdtSDTDoctores>[] aP15 ,
                             short[] aP16 )
   {
      prcmostrardoctoresporfiltro.this.AV35OpListado = aP0;
      prcmostrardoctoresporfiltro.this.AV22EspeciadadId = aP1;
      prcmostrardoctoresporfiltro.this.AV41TipoCita = aP2;
      prcmostrardoctoresporfiltro.this.AV26FechaCita = aP3;
      prcmostrardoctoresporfiltro.this.AV34NombresApellidosDoctor = aP4;
      prcmostrardoctoresporfiltro.this.AV28GeneroFemenino = aP5;
      prcmostrardoctoresporfiltro.this.AV29GeneroMasculino = aP6;
      prcmostrardoctoresporfiltro.this.AV9AtencionPresencial = aP7;
      prcmostrardoctoresporfiltro.this.AV10AtencionVirtual = aP8;
      prcmostrardoctoresporfiltro.this.AV8AtencionDomicilio = aP9;
      prcmostrardoctoresporfiltro.this.AV25Especialidades = aP10;
      prcmostrardoctoresporfiltro.this.AV37Precios = aP11;
      prcmostrardoctoresporfiltro.this.AV15DepartamentoId = aP12;
      prcmostrardoctoresporfiltro.this.AV39ProvinciaId = aP13;
      prcmostrardoctoresporfiltro.this.AV19DistritoId = aP14;
      prcmostrardoctoresporfiltro.this.aP15 = aP15;
      prcmostrardoctoresporfiltro.this.aP16 = aP16;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV27Genero = AV28GeneroFemenino + AV29GeneroMasculino ;
      AV27Genero = GXutil.strReplace( AV27Genero, "S", "") ;
      AV42TiposDeCita = AV9AtencionPresencial + AV10AtencionVirtual + AV8AtencionDomicilio ;
      AV42TiposDeCita = GXutil.strReplace( AV42TiposDeCita, "N", "") ;
      AV11ContadorEspecialidad = (short)(0) ;
      AV46GXV1 = 1 ;
      while ( AV46GXV1 <= AV25Especialidades.size() )
      {
         AV23Especialidad = (com.projectthani.SdtSDTEspecialidad)((com.projectthani.SdtSDTEspecialidad)AV25Especialidades.elementAt(-1+AV46GXV1));
         if ( AV23Especialidad.getgxTv_SdtSDTEspecialidad_Especialidadcheck() )
         {
            AV11ContadorEspecialidad = (short)(AV11ContadorEspecialidad+1) ;
            AV33ListEspecialidades += GXutil.str( AV23Especialidad.getgxTv_SdtSDTEspecialidad_Especialidadid(), 4, 0) + " - " ;
         }
         AV46GXV1 = (int)(AV46GXV1+1) ;
      }
      AV33ListEspecialidades = GXutil.substring( AV33ListEspecialidades, 1, GXutil.len( AV33ListEspecialidades)-1) ;
      AV12ContadorPrecio = (short)(0) ;
      AV47GXV2 = 1 ;
      while ( AV47GXV2 <= AV37Precios.size() )
      {
         AV36Precio = (com.projectthani.SdtSDTRangoPrecios)((com.projectthani.SdtSDTRangoPrecios)AV37Precios.elementAt(-1+AV47GXV2));
         if ( AV36Precio.getgxTv_SdtSDTRangoPrecios_Estado() )
         {
            AV12ContadorPrecio = (short)(AV12ContadorPrecio+1) ;
         }
         AV47GXV2 = (int)(AV47GXV2+1) ;
      }
      if ( GXutil.strcmp(AV35OpListado, "SinFiltros") == 0 )
      {
         /* Using cursor P00592 */
         pr_default.execute(0, new Object[] {Gx_date});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A136DisponibilidadEstado = P00592_A136DisponibilidadEstado[0] ;
            A139DisponibilidadEstadoCita = P00592_A139DisponibilidadEstadoCita[0] ;
            A67DisponibilidadFecha = P00592_A67DisponibilidadFecha[0] ;
            n67DisponibilidadFecha = P00592_n67DisponibilidadFecha[0] ;
            A31ProfesionalId = P00592_A31ProfesionalId[0] ;
            AV30ListaDisp = (com.projectthani.SdtSDTPrdofesionalDisponibilidadFiltro)new com.projectthani.SdtSDTPrdofesionalDisponibilidadFiltro(remoteHandle, context);
            AV30ListaDisp.setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Profesionalid( A31ProfesionalId );
            GXv_date1[0] = AV16DisponibilidadFecha ;
            GXv_char2[0] = AV18DisponibilidadTipoCitas ;
            new com.projectthani.prcgetfechaminandtipocita(remoteHandle, context).execute( A31ProfesionalId, GXv_date1, GXv_char2) ;
            prcmostrardoctoresporfiltro.this.AV16DisponibilidadFecha = GXv_date1[0] ;
            prcmostrardoctoresporfiltro.this.AV18DisponibilidadTipoCitas = GXv_char2[0] ;
            AV30ListaDisp.setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita( AV16DisponibilidadFecha );
            AV30ListaDisp.setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Tipocita( AV18DisponibilidadTipoCitas );
            GXv_char2[0] = AV24EspecialidadDescripcion ;
            new com.projectthani.prcgetespecialidadbyprofesional(remoteHandle, context).execute( A31ProfesionalId, GXv_char2) ;
            prcmostrardoctoresporfiltro.this.AV24EspecialidadDescripcion = GXv_char2[0] ;
            AV30ListaDisp.setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Especialidad( AV24EspecialidadDescripcion );
            GXv_char2[0] = AV13CostoCita ;
            new com.projectthani.prcgetlistadocostocita(remoteHandle, context).execute( A31ProfesionalId, GXv_char2) ;
            prcmostrardoctoresporfiltro.this.AV13CostoCita = GXv_char2[0] ;
            AV30ListaDisp.setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Costocita( AV13CostoCita );
            AV31ListaDisponibilidad.add(AV30ListaDisp, 0);
            pr_default.readNext(0);
         }
         pr_default.close(0);
      }
      else if ( GXutil.strcmp(AV35OpListado, "FiltroNombresApellidos") == 0 )
      {
         /* Using cursor P00593 */
         pr_default.execute(1, new Object[] {Gx_date, AV34NombresApellidosDoctor, AV34NombresApellidosDoctor, AV34NombresApellidosDoctor});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A84ProfesionalNombres = P00593_A84ProfesionalNombres[0] ;
            A86ProfesionalApellidoMaterno = P00593_A86ProfesionalApellidoMaterno[0] ;
            A85ProfesionalApellidoPaterno = P00593_A85ProfesionalApellidoPaterno[0] ;
            A136DisponibilidadEstado = P00593_A136DisponibilidadEstado[0] ;
            A139DisponibilidadEstadoCita = P00593_A139DisponibilidadEstadoCita[0] ;
            A67DisponibilidadFecha = P00593_A67DisponibilidadFecha[0] ;
            n67DisponibilidadFecha = P00593_n67DisponibilidadFecha[0] ;
            A31ProfesionalId = P00593_A31ProfesionalId[0] ;
            A84ProfesionalNombres = P00593_A84ProfesionalNombres[0] ;
            A86ProfesionalApellidoMaterno = P00593_A86ProfesionalApellidoMaterno[0] ;
            A85ProfesionalApellidoPaterno = P00593_A85ProfesionalApellidoPaterno[0] ;
            AV30ListaDisp = (com.projectthani.SdtSDTPrdofesionalDisponibilidadFiltro)new com.projectthani.SdtSDTPrdofesionalDisponibilidadFiltro(remoteHandle, context);
            AV30ListaDisp.setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Profesionalid( A31ProfesionalId );
            GXv_date1[0] = AV16DisponibilidadFecha ;
            GXv_char2[0] = AV18DisponibilidadTipoCitas ;
            new com.projectthani.prcgetfechaminandtipocita(remoteHandle, context).execute( A31ProfesionalId, GXv_date1, GXv_char2) ;
            prcmostrardoctoresporfiltro.this.AV16DisponibilidadFecha = GXv_date1[0] ;
            prcmostrardoctoresporfiltro.this.AV18DisponibilidadTipoCitas = GXv_char2[0] ;
            AV30ListaDisp.setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita( AV16DisponibilidadFecha );
            AV30ListaDisp.setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Tipocita( AV18DisponibilidadTipoCitas );
            GXv_char2[0] = AV24EspecialidadDescripcion ;
            new com.projectthani.prcgetespecialidadbyprofesional(remoteHandle, context).execute( A31ProfesionalId, GXv_char2) ;
            prcmostrardoctoresporfiltro.this.AV24EspecialidadDescripcion = GXv_char2[0] ;
            AV30ListaDisp.setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Especialidad( AV24EspecialidadDescripcion );
            GXv_char2[0] = AV13CostoCita ;
            new com.projectthani.prcgetlistadocostocita(remoteHandle, context).execute( A31ProfesionalId, GXv_char2) ;
            prcmostrardoctoresporfiltro.this.AV13CostoCita = GXv_char2[0] ;
            AV30ListaDisp.setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Costocita( AV13CostoCita );
            AV31ListaDisponibilidad.add(AV30ListaDisp, 0);
            pr_default.readNext(1);
         }
         pr_default.close(1);
      }
      else if ( GXutil.strcmp(AV35OpListado, "FiltroGeneral") == 0 )
      {
         /* Using cursor P00594 */
         pr_default.execute(2, new Object[] {Gx_date, AV27Genero, AV27Genero, AV42TiposDeCita, AV42TiposDeCita, AV33ListEspecialidades, AV33ListEspecialidades});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A32EspecialidadId = P00594_A32EspecialidadId[0] ;
            A298DisponibilidadTipoCita = P00594_A298DisponibilidadTipoCita[0] ;
            A177ProfesionalSexo = P00594_A177ProfesionalSexo[0] ;
            A136DisponibilidadEstado = P00594_A136DisponibilidadEstado[0] ;
            A139DisponibilidadEstadoCita = P00594_A139DisponibilidadEstadoCita[0] ;
            A67DisponibilidadFecha = P00594_A67DisponibilidadFecha[0] ;
            n67DisponibilidadFecha = P00594_n67DisponibilidadFecha[0] ;
            A30SedeId = P00594_A30SedeId[0] ;
            A31ProfesionalId = P00594_A31ProfesionalId[0] ;
            A177ProfesionalSexo = P00594_A177ProfesionalSexo[0] ;
            A30SedeId = P00594_A30SedeId[0] ;
            AV30ListaDisp = (com.projectthani.SdtSDTPrdofesionalDisponibilidadFiltro)new com.projectthani.SdtSDTPrdofesionalDisponibilidadFiltro(remoteHandle, context);
            AV30ListaDisp.setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Profesionalid( A31ProfesionalId );
            GXv_date1[0] = AV16DisponibilidadFecha ;
            GXv_char2[0] = AV18DisponibilidadTipoCitas ;
            new com.projectthani.prcgetfechaminandtipocita(remoteHandle, context).execute( A31ProfesionalId, GXv_date1, GXv_char2) ;
            prcmostrardoctoresporfiltro.this.AV16DisponibilidadFecha = GXv_date1[0] ;
            prcmostrardoctoresporfiltro.this.AV18DisponibilidadTipoCitas = GXv_char2[0] ;
            AV30ListaDisp.setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita( AV16DisponibilidadFecha );
            AV30ListaDisp.setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Tipocita( AV18DisponibilidadTipoCitas );
            GXv_char2[0] = AV24EspecialidadDescripcion ;
            new com.projectthani.prcgetespecialidadbyprofesional(remoteHandle, context).execute( A31ProfesionalId, GXv_char2) ;
            prcmostrardoctoresporfiltro.this.AV24EspecialidadDescripcion = GXv_char2[0] ;
            AV30ListaDisp.setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Especialidad( AV24EspecialidadDescripcion );
            GXv_char2[0] = AV13CostoCita ;
            new com.projectthani.prcgetlistadocostocita(remoteHandle, context).execute( A31ProfesionalId, GXv_char2) ;
            prcmostrardoctoresporfiltro.this.AV13CostoCita = GXv_char2[0] ;
            AV30ListaDisp.setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Costocita( AV13CostoCita );
            AV31ListaDisponibilidad.add(AV30ListaDisp, 0);
            pr_default.readNext(2);
         }
         pr_default.close(2);
      }
      else if ( GXutil.strcmp(AV35OpListado, "FiltroHomePage") == 0 )
      {
         /* Using cursor P00595 */
         pr_default.execute(3, new Object[] {AV26FechaCita, Integer.valueOf(AV22EspeciadadId), AV41TipoCita});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A298DisponibilidadTipoCita = P00595_A298DisponibilidadTipoCita[0] ;
            A32EspecialidadId = P00595_A32EspecialidadId[0] ;
            A67DisponibilidadFecha = P00595_A67DisponibilidadFecha[0] ;
            n67DisponibilidadFecha = P00595_n67DisponibilidadFecha[0] ;
            A136DisponibilidadEstado = P00595_A136DisponibilidadEstado[0] ;
            A139DisponibilidadEstadoCita = P00595_A139DisponibilidadEstadoCita[0] ;
            A31ProfesionalId = P00595_A31ProfesionalId[0] ;
            AV30ListaDisp = (com.projectthani.SdtSDTPrdofesionalDisponibilidadFiltro)new com.projectthani.SdtSDTPrdofesionalDisponibilidadFiltro(remoteHandle, context);
            AV30ListaDisp.setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Profesionalid( A31ProfesionalId );
            GXv_date1[0] = AV16DisponibilidadFecha ;
            GXv_char2[0] = AV18DisponibilidadTipoCitas ;
            new com.projectthani.prcgetfechaminandtipocita(remoteHandle, context).execute( A31ProfesionalId, GXv_date1, GXv_char2) ;
            prcmostrardoctoresporfiltro.this.AV16DisponibilidadFecha = GXv_date1[0] ;
            prcmostrardoctoresporfiltro.this.AV18DisponibilidadTipoCitas = GXv_char2[0] ;
            AV30ListaDisp.setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita( AV16DisponibilidadFecha );
            AV30ListaDisp.setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Tipocita( AV18DisponibilidadTipoCitas );
            GXv_char2[0] = AV24EspecialidadDescripcion ;
            new com.projectthani.prcgetespecialidadbyprofesional(remoteHandle, context).execute( A31ProfesionalId, GXv_char2) ;
            prcmostrardoctoresporfiltro.this.AV24EspecialidadDescripcion = GXv_char2[0] ;
            AV30ListaDisp.setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Especialidad( AV24EspecialidadDescripcion );
            GXv_char2[0] = AV13CostoCita ;
            new com.projectthani.prcgetlistadocostocita(remoteHandle, context).execute( A31ProfesionalId, GXv_char2) ;
            prcmostrardoctoresporfiltro.this.AV13CostoCita = GXv_char2[0] ;
            AV30ListaDisp.setgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Costocita( AV13CostoCita );
            AV31ListaDisponibilidad.add(AV30ListaDisp, 0);
            pr_default.readNext(3);
         }
         pr_default.close(3);
      }
      AV53GXV3 = 1 ;
      while ( AV53GXV3 <= AV31ListaDisponibilidad.size() )
      {
         AV32ListaProfesionalID = (com.projectthani.SdtSDTPrdofesionalDisponibilidadFiltro)((com.projectthani.SdtSDTPrdofesionalDisponibilidadFiltro)AV31ListaDisponibilidad.elementAt(-1+AV53GXV3));
         AV38ProfesionalId = AV32ListaProfesionalID.getgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Profesionalid() ;
         /* Using cursor P00596 */
         pr_default.execute(4, new Object[] {Integer.valueOf(AV38ProfesionalId)});
         while ( (pr_default.getStatus(4) != 101) )
         {
            A31ProfesionalId = P00596_A31ProfesionalId[0] ;
            A40000ProfesionalFoto_GXI = P00596_A40000ProfesionalFoto_GXI[0] ;
            A175ProfesionalNombreCompleto2 = P00596_A175ProfesionalNombreCompleto2[0] ;
            A189ProfesionalFoto = P00596_A189ProfesionalFoto[0] ;
            A183ProfesionalDireccion = P00596_A183ProfesionalDireccion[0] ;
            A85ProfesionalApellidoPaterno = P00596_A85ProfesionalApellidoPaterno[0] ;
            A86ProfesionalApellidoMaterno = P00596_A86ProfesionalApellidoMaterno[0] ;
            A84ProfesionalNombres = P00596_A84ProfesionalNombres[0] ;
            AV20Doctor = (com.projectthani.SdtSDTDoctores)new com.projectthani.SdtSDTDoctores(remoteHandle, context);
            AV20Doctor.setgxTv_SdtSDTDoctores_Profesionalid( A31ProfesionalId );
            AV20Doctor.setgxTv_SdtSDTDoctores_Sdtdoctoresreservarcita( (short)(A31ProfesionalId) );
            AV20Doctor.setgxTv_SdtSDTDoctores_Sdtdoctoresverperfil( (short)(A31ProfesionalId) );
            AV20Doctor.setgxTv_SdtSDTDoctores_Apellidosnombres( A175ProfesionalNombreCompleto2 );
            AV20Doctor.setgxTv_SdtSDTDoctores_Direccion( A183ProfesionalDireccion );
            AV20Doctor.setgxTv_SdtSDTDoctores_Fotografia( A189ProfesionalFoto );
            AV20Doctor.setgxTv_SdtSDTDoctores_Fotografia_gxi( A40000ProfesionalFoto_GXI );
            AV20Doctor.setgxTv_SdtSDTDoctores_Especialidad( AV32ListaProfesionalID.getgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Especialidad() );
            AV20Doctor.setgxTv_SdtSDTDoctores_Disponibilidad( AV32ListaProfesionalID.getgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Fechacita() );
            AV20Doctor.setgxTv_SdtSDTDoctores_Tipocita( AV32ListaProfesionalID.getgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Tipocita() );
            AV20Doctor.setgxTv_SdtSDTDoctores_Precioconsulta( AV32ListaProfesionalID.getgxTv_SdtSDTPrdofesionalDisponibilidadFiltro_Costocita() );
            GXv_char2[0] = AV40Rating ;
            new com.projectthani.prcratingprofesionalouthtml(remoteHandle, context).execute( A31ProfesionalId, GXv_char2) ;
            prcmostrardoctoresporfiltro.this.AV40Rating = GXv_char2[0] ;
            AV20Doctor.setgxTv_SdtSDTDoctores_Calificacion( AV40Rating );
            AV21Doctores.add(AV20Doctor, 0);
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(4);
         AV53GXV3 = (int)(AV53GXV3+1) ;
      }
      AV43NroItem = (short)(AV21Doctores.size()) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP15[0] = prcmostrardoctoresporfiltro.this.AV21Doctores;
      this.aP16[0] = prcmostrardoctoresporfiltro.this.AV43NroItem;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV21Doctores = new GXBaseCollection<com.projectthani.SdtSDTDoctores>(com.projectthani.SdtSDTDoctores.class, "SDTDoctores", "ProjectThani", remoteHandle);
      AV27Genero = "" ;
      AV42TiposDeCita = "" ;
      AV23Especialidad = new com.projectthani.SdtSDTEspecialidad(remoteHandle, context);
      AV33ListEspecialidades = "" ;
      AV36Precio = new com.projectthani.SdtSDTRangoPrecios(remoteHandle, context);
      scmdbuf = "" ;
      Gx_date = GXutil.nullDate() ;
      P00592_A136DisponibilidadEstado = new String[] {""} ;
      P00592_A139DisponibilidadEstadoCita = new String[] {""} ;
      P00592_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P00592_n67DisponibilidadFecha = new boolean[] {false} ;
      P00592_A31ProfesionalId = new int[1] ;
      A136DisponibilidadEstado = "" ;
      A139DisponibilidadEstadoCita = "" ;
      A67DisponibilidadFecha = GXutil.nullDate() ;
      AV30ListaDisp = new com.projectthani.SdtSDTPrdofesionalDisponibilidadFiltro(remoteHandle, context);
      AV16DisponibilidadFecha = GXutil.nullDate() ;
      AV18DisponibilidadTipoCitas = "" ;
      AV24EspecialidadDescripcion = "" ;
      AV13CostoCita = "" ;
      AV31ListaDisponibilidad = new GXBaseCollection<com.projectthani.SdtSDTPrdofesionalDisponibilidadFiltro>(com.projectthani.SdtSDTPrdofesionalDisponibilidadFiltro.class, "SDTPrdofesionalDisponibilidadFiltro", "ProjectThani", remoteHandle);
      P00593_A84ProfesionalNombres = new String[] {""} ;
      P00593_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P00593_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P00593_A136DisponibilidadEstado = new String[] {""} ;
      P00593_A139DisponibilidadEstadoCita = new String[] {""} ;
      P00593_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P00593_n67DisponibilidadFecha = new boolean[] {false} ;
      P00593_A31ProfesionalId = new int[1] ;
      A84ProfesionalNombres = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      P00594_A32EspecialidadId = new short[1] ;
      P00594_A298DisponibilidadTipoCita = new String[] {""} ;
      P00594_A177ProfesionalSexo = new String[] {""} ;
      P00594_A136DisponibilidadEstado = new String[] {""} ;
      P00594_A139DisponibilidadEstadoCita = new String[] {""} ;
      P00594_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P00594_n67DisponibilidadFecha = new boolean[] {false} ;
      P00594_A30SedeId = new short[1] ;
      P00594_A31ProfesionalId = new int[1] ;
      A298DisponibilidadTipoCita = "" ;
      A177ProfesionalSexo = "" ;
      P00595_A298DisponibilidadTipoCita = new String[] {""} ;
      P00595_A32EspecialidadId = new short[1] ;
      P00595_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P00595_n67DisponibilidadFecha = new boolean[] {false} ;
      P00595_A136DisponibilidadEstado = new String[] {""} ;
      P00595_A139DisponibilidadEstadoCita = new String[] {""} ;
      P00595_A31ProfesionalId = new int[1] ;
      GXv_date1 = new java.util.Date[1] ;
      AV32ListaProfesionalID = new com.projectthani.SdtSDTPrdofesionalDisponibilidadFiltro(remoteHandle, context);
      P00596_A31ProfesionalId = new int[1] ;
      P00596_A40000ProfesionalFoto_GXI = new String[] {""} ;
      P00596_A175ProfesionalNombreCompleto2 = new String[] {""} ;
      P00596_A189ProfesionalFoto = new String[] {""} ;
      P00596_A183ProfesionalDireccion = new String[] {""} ;
      P00596_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P00596_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P00596_A84ProfesionalNombres = new String[] {""} ;
      A40000ProfesionalFoto_GXI = "" ;
      A175ProfesionalNombreCompleto2 = "" ;
      A189ProfesionalFoto = "" ;
      A183ProfesionalDireccion = "" ;
      AV20Doctor = new com.projectthani.SdtSDTDoctores(remoteHandle, context);
      AV40Rating = "" ;
      GXv_char2 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcmostrardoctoresporfiltro__default(),
         new Object[] {
             new Object[] {
            P00592_A136DisponibilidadEstado, P00592_A139DisponibilidadEstadoCita, P00592_A67DisponibilidadFecha, P00592_n67DisponibilidadFecha, P00592_A31ProfesionalId
            }
            , new Object[] {
            P00593_A84ProfesionalNombres, P00593_A86ProfesionalApellidoMaterno, P00593_A85ProfesionalApellidoPaterno, P00593_A136DisponibilidadEstado, P00593_A139DisponibilidadEstadoCita, P00593_A67DisponibilidadFecha, P00593_n67DisponibilidadFecha, P00593_A31ProfesionalId
            }
            , new Object[] {
            P00594_A32EspecialidadId, P00594_A298DisponibilidadTipoCita, P00594_A177ProfesionalSexo, P00594_A136DisponibilidadEstado, P00594_A139DisponibilidadEstadoCita, P00594_A67DisponibilidadFecha, P00594_n67DisponibilidadFecha, P00594_A30SedeId, P00594_A31ProfesionalId
            }
            , new Object[] {
            P00595_A298DisponibilidadTipoCita, P00595_A32EspecialidadId, P00595_A67DisponibilidadFecha, P00595_n67DisponibilidadFecha, P00595_A136DisponibilidadEstado, P00595_A139DisponibilidadEstadoCita, P00595_A31ProfesionalId
            }
            , new Object[] {
            P00596_A31ProfesionalId, P00596_A40000ProfesionalFoto_GXI, P00596_A175ProfesionalNombreCompleto2, P00596_A189ProfesionalFoto, P00596_A183ProfesionalDireccion, P00596_A85ProfesionalApellidoPaterno, P00596_A86ProfesionalApellidoMaterno, P00596_A84ProfesionalNombres
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      /* GeneXus formulas. */
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
   }

   private short AV43NroItem ;
   private short AV11ContadorEspecialidad ;
   private short AV12ContadorPrecio ;
   private short A32EspecialidadId ;
   private short A30SedeId ;
   private short Gx_err ;
   private int AV22EspeciadadId ;
   private int AV46GXV1 ;
   private int AV47GXV2 ;
   private int A31ProfesionalId ;
   private int AV53GXV3 ;
   private int AV38ProfesionalId ;
   private String AV35OpListado ;
   private String AV41TipoCita ;
   private String AV28GeneroFemenino ;
   private String AV29GeneroMasculino ;
   private String AV9AtencionPresencial ;
   private String AV10AtencionVirtual ;
   private String AV8AtencionDomicilio ;
   private String scmdbuf ;
   private String A136DisponibilidadEstado ;
   private String A298DisponibilidadTipoCita ;
   private String A177ProfesionalSexo ;
   private String GXv_char2[] ;
   private java.util.Date AV26FechaCita ;
   private java.util.Date Gx_date ;
   private java.util.Date A67DisponibilidadFecha ;
   private java.util.Date AV16DisponibilidadFecha ;
   private java.util.Date GXv_date1[] ;
   private boolean n67DisponibilidadFecha ;
   private String AV40Rating ;
   private String AV34NombresApellidosDoctor ;
   private String AV15DepartamentoId ;
   private String AV39ProvinciaId ;
   private String AV19DistritoId ;
   private String AV27Genero ;
   private String AV42TiposDeCita ;
   private String AV33ListEspecialidades ;
   private String A139DisponibilidadEstadoCita ;
   private String AV18DisponibilidadTipoCitas ;
   private String AV24EspecialidadDescripcion ;
   private String AV13CostoCita ;
   private String A84ProfesionalNombres ;
   private String A86ProfesionalApellidoMaterno ;
   private String A85ProfesionalApellidoPaterno ;
   private String A40000ProfesionalFoto_GXI ;
   private String A175ProfesionalNombreCompleto2 ;
   private String A183ProfesionalDireccion ;
   private String A189ProfesionalFoto ;
   private short[] aP16 ;
   private GXBaseCollection<com.projectthani.SdtSDTDoctores>[] aP15 ;
   private IDataStoreProvider pr_default ;
   private String[] P00592_A136DisponibilidadEstado ;
   private String[] P00592_A139DisponibilidadEstadoCita ;
   private java.util.Date[] P00592_A67DisponibilidadFecha ;
   private boolean[] P00592_n67DisponibilidadFecha ;
   private int[] P00592_A31ProfesionalId ;
   private String[] P00593_A84ProfesionalNombres ;
   private String[] P00593_A86ProfesionalApellidoMaterno ;
   private String[] P00593_A85ProfesionalApellidoPaterno ;
   private String[] P00593_A136DisponibilidadEstado ;
   private String[] P00593_A139DisponibilidadEstadoCita ;
   private java.util.Date[] P00593_A67DisponibilidadFecha ;
   private boolean[] P00593_n67DisponibilidadFecha ;
   private int[] P00593_A31ProfesionalId ;
   private short[] P00594_A32EspecialidadId ;
   private String[] P00594_A298DisponibilidadTipoCita ;
   private String[] P00594_A177ProfesionalSexo ;
   private String[] P00594_A136DisponibilidadEstado ;
   private String[] P00594_A139DisponibilidadEstadoCita ;
   private java.util.Date[] P00594_A67DisponibilidadFecha ;
   private boolean[] P00594_n67DisponibilidadFecha ;
   private short[] P00594_A30SedeId ;
   private int[] P00594_A31ProfesionalId ;
   private String[] P00595_A298DisponibilidadTipoCita ;
   private short[] P00595_A32EspecialidadId ;
   private java.util.Date[] P00595_A67DisponibilidadFecha ;
   private boolean[] P00595_n67DisponibilidadFecha ;
   private String[] P00595_A136DisponibilidadEstado ;
   private String[] P00595_A139DisponibilidadEstadoCita ;
   private int[] P00595_A31ProfesionalId ;
   private int[] P00596_A31ProfesionalId ;
   private String[] P00596_A40000ProfesionalFoto_GXI ;
   private String[] P00596_A175ProfesionalNombreCompleto2 ;
   private String[] P00596_A189ProfesionalFoto ;
   private String[] P00596_A183ProfesionalDireccion ;
   private String[] P00596_A85ProfesionalApellidoPaterno ;
   private String[] P00596_A86ProfesionalApellidoMaterno ;
   private String[] P00596_A84ProfesionalNombres ;
   private GXBaseCollection<com.projectthani.SdtSDTDoctores> AV21Doctores ;
   private GXBaseCollection<com.projectthani.SdtSDTEspecialidad> AV25Especialidades ;
   private GXBaseCollection<com.projectthani.SdtSDTPrdofesionalDisponibilidadFiltro> AV31ListaDisponibilidad ;
   private GXBaseCollection<com.projectthani.SdtSDTRangoPrecios> AV37Precios ;
   private com.projectthani.SdtSDTDoctores AV20Doctor ;
   private com.projectthani.SdtSDTEspecialidad AV23Especialidad ;
   private com.projectthani.SdtSDTPrdofesionalDisponibilidadFiltro AV30ListaDisp ;
   private com.projectthani.SdtSDTPrdofesionalDisponibilidadFiltro AV32ListaProfesionalID ;
   private com.projectthani.SdtSDTRangoPrecios AV36Precio ;
}

final  class prcmostrardoctoresporfiltro__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00592", "SELECT DISTINCT NULL AS [DisponibilidadEstado], NULL AS [DisponibilidadEstadoCita], NULL AS [DisponibilidadFecha], [ProfesionalId] FROM ( SELECT TOP(100) PERCENT [DisponibilidadEstado], [DisponibilidadEstadoCita], [DisponibilidadFecha], [ProfesionalId] FROM [Disponibilidad] WHERE ([DisponibilidadFecha] >= ?) AND ([DisponibilidadEstadoCita] = 'L') AND ([DisponibilidadEstado] = 'A') ORDER BY [ProfesionalId]) DistinctT ORDER BY [ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00593", "SELECT DISTINCT NULL AS [ProfesionalNombres], NULL AS [ProfesionalApellidoMaterno], NULL AS [ProfesionalApellidoPaterno], NULL AS [DisponibilidadEstado], NULL AS [DisponibilidadEstadoCita], NULL AS [DisponibilidadFecha], [ProfesionalId] FROM ( SELECT TOP(100) PERCENT T2.[ProfesionalNombres], T2.[ProfesionalApellidoMaterno], T2.[ProfesionalApellidoPaterno], T1.[DisponibilidadEstado], T1.[DisponibilidadEstadoCita], T1.[DisponibilidadFecha], T1.[ProfesionalId] FROM ([Disponibilidad] T1 INNER JOIN [Profesional] T2 ON T2.[ProfesionalId] = T1.[ProfesionalId]) WHERE (T1.[DisponibilidadFecha] >= ?) AND ((CHARINDEX(RTRIM(?), T2.[ProfesionalNombres])) >= 1 or (CHARINDEX(RTRIM(?), T2.[ProfesionalApellidoMaterno])) >= 1 or (CHARINDEX(RTRIM(?), T2.[ProfesionalApellidoPaterno])) >= 1) AND (T1.[DisponibilidadEstadoCita] = 'L') AND (T1.[DisponibilidadEstado] = 'A') ORDER BY T1.[ProfesionalId]) DistinctT ORDER BY [ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00594", "SELECT DISTINCT [EspecialidadId], NULL AS [DisponibilidadTipoCita], NULL AS [ProfesionalSexo], NULL AS [DisponibilidadEstado], NULL AS [DisponibilidadEstadoCita], NULL AS [DisponibilidadFecha], [SedeId], [ProfesionalId] FROM ( SELECT TOP(100) PERCENT T1.[EspecialidadId], T1.[DisponibilidadTipoCita], T2.[ProfesionalSexo], T1.[DisponibilidadEstado], T1.[DisponibilidadEstadoCita], T1.[DisponibilidadFecha], T3.[SedeId], T1.[ProfesionalId] FROM (([Disponibilidad] T1 INNER JOIN [Profesional] T2 ON T2.[ProfesionalId] = T1.[ProfesionalId]) INNER JOIN [ProfesionalEspecialidadSede] T3 ON T3.[ProfesionalId] = T1.[ProfesionalId] AND T3.[EspecialidadId] = T1.[EspecialidadId]) WHERE (T1.[DisponibilidadFecha] >= ?) AND ((CHARINDEX(RTRIM(T2.[ProfesionalSexo]), ?)) > 0 or (? = '')) AND ((CHARINDEX(RTRIM(T1.[DisponibilidadTipoCita]), ?)) > 0 or (? = '')) AND ((CHARINDEX(RTRIM(CONVERT( char(4), CAST(T1.[EspecialidadId] AS decimal(4,0)))), ?)) > 0 or (? = '')) AND (T1.[DisponibilidadEstadoCita] = 'L') AND (T1.[DisponibilidadEstado] = 'A') ORDER BY T1.[ProfesionalId], T1.[EspecialidadId]) DistinctT ORDER BY [ProfesionalId], [EspecialidadId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00595", "SELECT DISTINCT NULL AS [DisponibilidadTipoCita], NULL AS [EspecialidadId], NULL AS [DisponibilidadFecha], NULL AS [DisponibilidadEstado], NULL AS [DisponibilidadEstadoCita], [ProfesionalId] FROM ( SELECT TOP(100) PERCENT [DisponibilidadTipoCita], [EspecialidadId], [DisponibilidadFecha], [DisponibilidadEstado], [DisponibilidadEstadoCita], [ProfesionalId] FROM [Disponibilidad] WHERE ([DisponibilidadEstadoCita] = 'L') AND ([DisponibilidadEstado] = 'A') AND ([DisponibilidadFecha] = ?) AND ([EspecialidadId] = ?) AND ([DisponibilidadTipoCita] = ?) ORDER BY [ProfesionalId]) DistinctT ORDER BY [ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00596", "SELECT DISTINCT [ProfesionalId], [ProfesionalFoto_GXI], [ProfesionalNombreCompleto2], [ProfesionalFoto], [ProfesionalDireccion], NULL AS [ProfesionalApellidoPaterno], NULL AS [ProfesionalApellidoMaterno], NULL AS [ProfesionalNombres] FROM ( SELECT TOP(100) PERCENT [ProfesionalId], [ProfesionalFoto_GXI], [ProfesionalApellidoPaterno] + ' ' + [ProfesionalApellidoMaterno] + ', ' + [ProfesionalNombres] AS ProfesionalNombreCompleto2, [ProfesionalFoto], [ProfesionalDireccion], [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno], [ProfesionalNombres] FROM [Profesional] WHERE [ProfesionalId] = ? ORDER BY [ProfesionalId]) DistinctT ORDER BY [ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(4);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((int[]) buf[7])[0] = rslt.getInt(7);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((short[]) buf[7])[0] = rslt.getShort(7);
               ((int[]) buf[8])[0] = rslt.getInt(8);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 1);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getMultimediaUri(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getMultimediaFile(4, rslt.getVarchar(2));
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               return;
            case 1 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setVarchar(2, (String)parms[1], 150);
               stmt.setVarchar(3, (String)parms[2], 150);
               stmt.setVarchar(4, (String)parms[3], 150);
               return;
            case 2 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setVarchar(2, (String)parms[1], 40);
               stmt.setVarchar(3, (String)parms[2], 40);
               stmt.setVarchar(4, (String)parms[3], 20);
               stmt.setVarchar(5, (String)parms[4], 20);
               stmt.setVarchar(6, (String)parms[5], 1000);
               stmt.setVarchar(7, (String)parms[6], 1000);
               return;
            case 3 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 2);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

