# app.py
import os
from flask import Flask, request

app = Flask(__name__)

@app.route('/ping')
def ping():
    # VULNERABILIDAD SAST: Inyección de comandos (Semgrep lo detectará)
    target = request.args.get('target')
    os.system(f"ping -c 1 {target}") 
    return "Ping enviado"

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)