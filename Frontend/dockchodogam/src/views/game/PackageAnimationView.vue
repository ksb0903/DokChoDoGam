<template>
  <div class="gacha">
    <div class="gacha__header">
      <h3 class="TITLE">π λμ΄λκ°μ μλ‘ μ€μ  κ²μ νμν΄μ π</h3>
      <p>
        μ€νν°ν©μ ν¬ν¨λ λ₯μ μλ μΆ©μ λ©λλ€. λκ°μ λͺ¨λ λͺ¨μ λκΉμ§ νμ΄ν!
      </p>
    </div>

    <div v-for="monster in monsterPackage" :key="monster.monsterId">
      <div class="gacha__body">
        <img
          class="gacha__img"
          :src="require('@/assets/monster/' + monster.monsterId + '.png')"
          alt=""
        />
        <p>{{ monster.name }}</p>
      </div>
    </div>

    <div class="gacha__footer">
      <div class="buttons">
        <button class="btn" @click="goToDogam">λκ°μμ νμΈνκΈ°</button>
      </div>
    </div>
    <div class="shop__exit" @click="goToGameShop()">
      <font-awesome-icon icon="fa-solid fa-x" size="xl" />
    </div>
  </div>
</template>

<script>
import JSConfetti from 'js-confetti'
import { mapGetters } from 'vuex'

const jsConfetti = new JSConfetti()

export default {
  data() {
    return {
      imageBaseUrl: process.env.VUE_APP_S3_URL
    }
  },
  computed: {
    ...mapGetters(['monsterPackage'])
  },
  methods: {
    goToDogam() {
      this.$router.replace({
        path: '/encyclopedia'
      })
    },
    startConfetti() {
      jsConfetti.addConfetti()
    }
  },
  created() {
    this.startConfetti()
  }
}
</script>

<style scoped>
.gacha {
  display: flex;
  flex-direction: column;
  justify-content: center;
  height: 100vh;
  width: 100vw;
  background-color: #ececec;
}

.gacha__header {
  text-align: center;
  margin-top: 5vh;
  margin-bottom: 5vh;
}

.card {
  position: relative;
  align-self: center;
  width: 15vw;
  height: 50vh;
  background: white;
  border-radius: 20px;
  overflow: hidden;
  margin-bottom: 2vh;
  margin-top: 2vh;
}

.container .card .imgBx {
  top: 35%;
  transform: translateY(0%);
  z-index: 10000;
  width: 100%;
  height: 220px;
  transition: 0.5s;
}

.container .card:hover .imgBx {
  top: 30%;
}

.container .card .imgBx img {
  top: 50%;
  transition: transform 0.25s ease;
  width: 50%;
}

.container .card .contentBx {
  position: absolute;
  bottom: 0;
  width: 100%;
  height: 20vh;
  text-align: center;
  transition: 1s;
  z-index: 10;
}

.container .card:hover .contentBx {
  height: 30vh;
}

.container .card .contentBx h2,
.container .card .contentBx p {
  position: relative;
  font-weight: 600;
  font-size: 1em;
  color: #000000;
  margin: 0;
  text-align: center;
}

.container .card .contentBx .size,
.container .card .contentBx .color {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 8px 20px;
  transition: 0.5s;
  opacity: 0;
  visibility: hidden;
  padding-top: 0;
  padding-bottom: 0;
  color: white;
}

.container .card:hover .contentBx .size {
  opacity: 1;
  visibility: visible;
  transition-delay: 0.5s;
}

.card__common {
  background-color: gray;
}
.card__rare {
  background-color: skyblue;
}
.card__epic {
  background-color: violet;
}
.card__legendary {
  background-color: yellow;
}
.card__special {
  background-image: url(https://img.freepik.com/premium-vector/glitters-rainbow-sky-shiny-rainbows-pastel-color-magic-fairy-starry-skies-and-glitter-sparkles-background-illustration_102902-1299.jpg?w=2000);
}

.gacha__footer {
  display: flex;
  flex-direction: row;
  align-self: center;
}

.buttons button {
  justify-content: space-around;
  margin: 2vh;
  border-radius: 20px;
}

.btn {
  width: 10vw;
  text-align: center;
  text-transform: uppercase;
  transition: 0.5s;
  color: black;
  text-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
  margin: auto;
  box-shadow: 0 0 5px #000;
  background-color: #a7c957;
  background-image: #a7c957;
}
.btn:hover {
  background-position: right center;
  background-color: #467302;
  color: white;
}

.shop__exit {
  width: 30px;
  height: 30px;
  border: 2px groove black;
  border-radius: 10px;
  display: flex;
  justify-content: center;
  align-items: center;
  position: absolute;
  top: 20px;
  right: 30px;
  cursor: pointer;
}
</style>
