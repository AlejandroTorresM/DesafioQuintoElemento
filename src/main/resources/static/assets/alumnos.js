const { createApp } = Vue
createApp({
    data() {
        return {
            alumnos: [],
            cursos: [],
            nombre:'',
            apellido:'',
            historia: '',
            fecDeNac: '',
            email: '',
            curso:'',
            id:'',
            nombreActualizado: '',
            apellidoActualizado: '',
            historiaActualizado: '',
            fecDeNacActualizada: '',
            emailActualizado: '',
        };
    },
    created() {
        this.cargarDatos();
        this.cargarCursos();
    },
    mounted() {},
    methods: {
        cargarDatos(){
            axios.get("/api/alumnos").then((e)=>{
                this.alumnos = e.data;
                console.log(this.alumnos);
            })
        },
        cargarCursos(){
            axios.get("/api/cursos").then((e)=>{
                this.cursos = e.data;
                console.log(this.cursos);
            })
        },
        crearAlumno(){
            axios.post("/api/alumnos",`curso=${this.curso}&nombre=${this.nombre}&apellido=${this.apellido}&fechaDeNacimiento=${this.fecDeNac}&historia=${this.historia}&email=${this.email}`).then(()=>alert("alumnoCreado")).then(()=>window.location.reload()).catch(error=>alert(`${error.response.data.message}`))
        },
        eliminarAlumno(alumno){
            axios.delete("api/alumnos/delete/"+alumno.id)
            .then(()=>alert("alumno eliminado"))
            .then(()=>window.location.reload())
            .catch(error=>alert(`${error.response.data.message}`))          
        },
        actualizarAlumno(alumno){
            axios.patch("/api/alumnos/update/"+alumno.id, `nombre=${this.nombreActualizado}&apellido=${this.apellidoActualizado}&fechaDeNacimiento=${this.fecDeNacActualizada}&historia=${this.historiaActualizado}&email=${this.emailActualizado}`)
            .then(()=>alert("NUEVOS DATOS DE ALUMNO"+" "+this.nombreActualizado+" "+this.apellidoActualizado+" "+this.fecDeNacActualizada+" "+this.historiaActualizado+" "+this.emailActualizado))
            .then(()=>window.location.reload())
            .catch(error=>alert(`${error.response.data.message}`))
        },
},
    computed: {},
    update: {}
}).mount("#app");