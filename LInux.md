## Использование команды cat в Linux
  954  cat > Pets.txt

  955  cat > "Pack animals".txt

  956  cat Pets "Pack animals.txt" > addiction.txt

  957  cat Pets.txt "Pack animals.txt" > addiction.txt

  958  ls

  959  ls tree

  960  tree

  961  mn addiction.txt "Human Friends".txt

  962  mv addiction.txt "Human Friends".txt

  963  ls
## Работа с директориями в Linux
  964  mkdir dir_for_animals

  965  mv Human\ Friends.txt dir_for_animals/

  966  ls

  967  cd dir_for_animals/

  968  cat Human\ Friends.txt 

  969  cd ..
## Работа с MySQL
  970  wget https://dev.mysql.com/get/mysql-apt-config_0.8.28-1_all.deb

  971  sudo dpkg -i mysql-apt-config_0.8.28-1_all.deb

  972  sudo apt-get update

  973  sudo apt-get install mysql-server
  ## Управление deb-пакетами

  974  sudo wget https://download.docker.com/linux/ubuntu/dists/jammy/pool/stable/amd64/docker-ce-cli_20.10.
  13~3-0~ubuntu-jammy_amd64.deb  

  975  sudo dpkg -i docker-ce-cli_20.10.13~3-0~ubuntu-jammy_amd64.deb 

  976  sudo dpkg -r docker-ce-cli  
  ## История команд 

  977  history >> "Kardapolov Vadim Vladimirovich, 25.01.2024, 4720".txt