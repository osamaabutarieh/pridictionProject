import subprocess
import sys

def install_requirements():
    # Use pip to install packages listed in requirements.txt
    subprocess.check_call([sys.executable, '-m', 'pip', 'install', '-r', 'requirements.txt'])

if __name__ == '__main__':
    install_requirements()
