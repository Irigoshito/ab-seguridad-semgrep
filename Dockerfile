# Usamos una imagen base antigua a propósito para que Trivy detecte vulnerabilidades de OS
FROM python:3.8-slim-buster

# Crear directorio de trabajo
WORKDIR /app

# Copiar archivos del laboratorio
COPY requirements.txt .
COPY app.py .

# Instalar dependencias
RUN pip install --no-cache-dir -r requirements.txt

# Exponer el puerto
EXPOSE 5000

# Ejecutar la aplicación
CMD ["python", "app.py"]