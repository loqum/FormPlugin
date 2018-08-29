package com.fihoca.bean;

import java.io.File;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import lombok.Data;

@Data
@ManagedBean(name = "alumno")
@RequestScoped
public class AlumnoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idAlumno;
	private String nombre;
	private String apellidos;
	private String dni;

	public AlumnoBean() {

	}

	public AlumnoBean(int idAlumno, String nombre, String apellidos, String dni) {
		super();
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
	}

	public String add(AlumnoBean alumno) throws Exception {
		System.out.println("Entra dentro del método add");

		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;
		Document document = null;

		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			document = builder.newDocument();

			// definimos el elemento raíz del documento
			Element eRaiz = document.createElement("Alumnos");
			document.appendChild(eRaiz);

			// definimos el nodo que contendrá los elementos
			Element eAlumno = document.createElement("Alumno");
			eRaiz.appendChild(eAlumno);

			// atributo para el nodo coche
			Attr atributo = document.createAttribute("id");
			atributo.setValue(String.valueOf(alumno.getIdAlumno()));
			eAlumno.setAttributeNode(atributo);

			// definimos cada uno de los elementos y le asignamos un valor
			Element eNombre = document.createElement("Nombre");
			eNombre.appendChild(document.createTextNode(alumno.getNombre()));
			eAlumno.appendChild(eNombre);

			Element eApellidos = document.createElement("Apellidos");
			eApellidos.appendChild(document.createTextNode(alumno.getApellidos()));
			eAlumno.appendChild(eApellidos);

			Element eDNI = document.createElement("DNI");
			eDNI.appendChild(document.createTextNode(alumno.getDni()));
			eAlumno.appendChild(eDNI);

			// clases necesarias finalizar la creación del archivo XML
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File("C:\\alumno.xml"));

			transformer.transform(source, result);

			System.out.println("File saved");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {

		}
		return "view";
	}

}
